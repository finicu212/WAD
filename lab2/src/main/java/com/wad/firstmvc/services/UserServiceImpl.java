package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repositories.ProductRepository;
import com.wad.firstmvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        //return users;
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users :: add);

        return users;
    }

    @Override
    public void save(User p) {
        //users.add(p);
        userRepository.save(p);
    }
}
