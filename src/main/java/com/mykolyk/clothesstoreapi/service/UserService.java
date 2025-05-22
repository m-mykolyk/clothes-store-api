package com.mykolyk.clothesstoreapi.service;

import com.mykolyk.clothesstoreapi.dto.UserDto;

public interface UserService {
    UserDto getUser(int id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(int id, UserDto userDto);

    void deleteUser(int id);
}
