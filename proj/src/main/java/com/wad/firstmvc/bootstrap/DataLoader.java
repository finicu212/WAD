package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.MaintenanceItem;
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

        MaintenanceItem mi;
        mi = new MaintenanceItem(0L, "Engine Oil VW", "VW-brand Longlife III 0W30 5L", "VW", 42.5f)

        List<User> users = userService.findAll();
        users.forEach(System.out::println);
    }
}
