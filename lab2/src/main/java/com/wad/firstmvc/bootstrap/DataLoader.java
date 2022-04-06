package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.services.ProductService;
import com.wad.firstmvc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    private final ProductService productService;
    private final UserService userService;

    public DataLoader(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Product p;
        p = new Product(0L, 2.5f, "candy", "food");
        productService.save(p);
        p = new Product(1L, 30.0f, "kebab", "food");
        productService.save(p);
        p = new Product(2L, 200.0f, "bike", "transport");
        productService.save(p);
        p = new Product(3L, 4000.0f, "car", "transport");
        productService.save(p);

        List<Product> products = productService.findAll();
        products.forEach(System.out::println);

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
