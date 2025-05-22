package com.mykolyk.clothesstoreapi.controller;

import com.mykolyk.clothesstoreapi.controller.assembler.UserAssembler;
import com.mykolyk.clothesstoreapi.controller.model.UserModel;
import com.mykolyk.clothesstoreapi.dto.UserDto;
import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import com.mykolyk.clothesstoreapi.dto.group.OnUpdate;
import com.mykolyk.clothesstoreapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserAssembler userAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users/{id}")
    public UserModel getUser(@PathVariable int id) {
        UserDto outUserDto = userService.getUser(id);
        return userAssembler.toModel(outUserDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users")
    public UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        UserDto outUserDto = userService.createUser(userDto);
        return userAssembler.toModel(outUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/users/{id}")
    public UserModel updateUser(@PathVariable int id, @Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        UserDto outUserDto = userService.updateUser(id, userDto);
        return userAssembler.toModel(outUserDto);
    }

    @DeleteMapping(value = "users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
