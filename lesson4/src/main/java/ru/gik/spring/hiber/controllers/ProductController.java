package ru.gik.spring.hiber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gik.spring.hiber.model.Product;
import ru.gik.spring.hiber.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products_all";
    }

    @GetMapping("/lessGreat")
    public String getLess(@RequestParam(value = "digMin", required = false) Integer digMin,
                          @RequestParam(value = "digMax", required = false) Integer digMax, Model model) {
        model.addAttribute("products", productService.greaterAndLessThan(digMax, digMin));
        return "products_all";
    }

}
