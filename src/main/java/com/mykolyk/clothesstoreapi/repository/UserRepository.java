package com.mykolyk.clothesstoreapi.repository;

import com.mykolyk.clothesstoreapi.model.User;

public interface UserRepository {
    User getUser(int id);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
