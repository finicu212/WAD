package com.wad.firstmvc.controllers;


import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //-populate the model with the retrieved products!
    //-select the appropriate view (navigation)
    @GetMapping
    public String viewProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String showAddProductForm(Model model){
        model.addAttribute("product",new Product());
        return "addproducts";
    }

    @GetMapping("/find")
    public String showFindProductsForm() {
        return "findproducts";
    }

    @PostMapping("/find")
    public String findProducts(@RequestParam(required = false)String category,
                               @RequestParam(required = false)String min_price,
                               @RequestParam(required = false)String max_price,
                               Model model) {
        category = category == null ? "" : category;
        min_price = min_price == null ? "" : min_price;
        max_price = max_price == null ? "" : max_price;

        if (max_price.isEmpty() || min_price.isEmpty())
            model.addAttribute("products", productService.findProducts(category));
        else
            model.addAttribute("products", productService.findProducts(category, Float.parseFloat(min_price), Float.parseFloat(max_price)));

        return "products";
    }

    @PostMapping("/new")
    public String addProduct(Product product){
        if(product.getId()==null)
            product.setId(new Random().nextLong());
        productService.save(product);
        return "redirect:/products";
    }
}
