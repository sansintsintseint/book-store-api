package com.example.bookstoreapi.security.service;

import com.example.bookstoreapi.dao.UserRepository;
import com.example.bookstoreapi.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User saveUSer(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName).orElse(null);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
