package com.mykolyk.clothesstoreapi.service.impl;

import com.mykolyk.clothesstoreapi.dto.UserDto;
import com.mykolyk.clothesstoreapi.model.User;
import com.mykolyk.clothesstoreapi.repository.UserRepository;
import com.mykolyk.clothesstoreapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(int id) {
        log.info("getUser by id {}", id);
        return mapUserToUserDto(userRepository.getUser(id));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with id {}", userDto.getId());
        return mapUserToUserDto(userRepository.createUser(mapUserDtoToUser(userDto)));
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        log.info("updateUser with id {}", id);
        User user = mapUserDtoToUser(userDto);

        User oldUser = userRepository.getUser(id);
        user.setId(oldUser.getId());
        user.setPassword(oldUser.getPassword());

        user = userRepository.updateUser(id, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(int id) {
        log.info("deleteUser with id {}", id);
        userRepository.deleteUser(id);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .repeatPassword(user.getPassword())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
