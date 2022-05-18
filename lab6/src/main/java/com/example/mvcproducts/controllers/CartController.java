package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping
    public String showCart(Model model, Authentication authentication) {
        model.addAttribute("products", productService.findAll());
        User user = (User) authentication.getPrincipal();
        return "cart_a";
    }
}
