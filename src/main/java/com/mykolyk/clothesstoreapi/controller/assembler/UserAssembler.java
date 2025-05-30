package com.mykolyk.clothesstoreapi.controller.assembler;

import com.mykolyk.clothesstoreapi.controller.UserController;
import com.mykolyk.clothesstoreapi.controller.model.UserModel;
import com.mykolyk.clothesstoreapi.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {
    public static final String GET_REL = "get_user";
    public static final String CREATE_REL = "create_user";
    public static final String UPDATE_USER = "update_user";
    public static final String DELETE_USER = "delete_user";

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getId())).withRel(GET_REL);
        Link create = linkTo(methodOn(UserController.class).createUser(entity)).withRel(CREATE_REL);
        Link update = linkTo(methodOn(UserController.class).updateUser(entity.getId(), entity)).withRel(UPDATE_USER);
        Link delete = linkTo(methodOn(UserController.class).deleteUser(entity.getId())).withRel(DELETE_USER);

        userModel.add(get, create, update, delete);

        return userModel;
    }
}
