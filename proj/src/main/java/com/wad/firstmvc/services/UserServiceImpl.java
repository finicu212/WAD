package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users :: add);

        return users;
    }

    @Override
    public void save(User p) {
        userRepository.save(p);
    }
}
