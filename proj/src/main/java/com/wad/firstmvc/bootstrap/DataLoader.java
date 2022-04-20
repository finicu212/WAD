package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User u;
        u = new User(0L, "avirtopeanu", "alexc.virtopeanu@gmail.com");
        userService.save(u);
        u = new User(1L, "gsavu98", "gabi.savu@ionos.com");
        userService.save(u);
        u = new User(2L, "cristig", "gristig@gmail.com");
        userService.save(u);
        u = new User(3L, "ioanam", "ioanam@gmail.com");
        userService.save(u);

        List<User> users = userService.findAll();
        users.forEach(System.out::println);
    }
}
