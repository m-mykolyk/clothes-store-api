package com.mykolyk.clothesstoreapi.repository.impl;

import com.mykolyk.clothesstoreapi.exception.UserNotFoundException;
import com.mykolyk.clothesstoreapi.model.User;
import com.mykolyk.clothesstoreapi.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User getUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        boolean isDeleted = users.removeIf(u -> u.getId() == id);
        if(isDeleted) {
            users.add(user);
        } else {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
