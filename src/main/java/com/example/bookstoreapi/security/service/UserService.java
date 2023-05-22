package com.example.bookstoreapi.security.service;

import com.example.bookstoreapi.security.model.User;

import java.util.List;

public interface UserService {
    User saveUSer(User user);

    User findByUserName(String userName);
    List<User> findAllUser();
}
