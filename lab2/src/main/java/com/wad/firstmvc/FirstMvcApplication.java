package com.wad.firstmvc;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.services.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FirstMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstMvcApplication.class, args);
    }

}
