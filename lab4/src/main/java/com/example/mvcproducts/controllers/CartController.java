package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Cart;
import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public String showCartContents(Model model, @ModelAttribute("cart") Cart cart) {
        model.addAttribute("products", cart.getProducts());
        System.out.println("Listing objects in cart..");
        for (Product p1 : cart.getProducts())
            System.out.println(p1.getDescription());
        return "products";
    }

    @RequestMapping(value = "/addToCart/{pid}", method = RequestMethod.GET)
    public String addToCart(@PathVariable Long pid, @ModelAttribute("cart") Cart cart) {
        Product p = productService.findById(pid);
        cart.addProduct(p);

        System.out.println("added product with id " + pid);
        return "products";
    }
}
