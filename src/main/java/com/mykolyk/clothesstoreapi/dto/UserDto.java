package com.mykolyk.clothesstoreapi.dto;

import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import com.mykolyk.clothesstoreapi.dto.group.OnUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int id;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "'lastName' shouldn't be empty", groups = OnCreate.class)
    private String lastName;

    @Email
    @Null(message = "'email' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'email' shouldn't be empty", groups = OnCreate.class)
    private String email;

    @Null(message = "'password' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    private String password;

    @Null(message = "'repeatPassword' should be absent in request", groups = OnUpdate.class)
    @NotBlank(message = "'repeatPassword' shouldn't be empty!", groups = OnCreate.class)
    private String repeatPassword;
}
