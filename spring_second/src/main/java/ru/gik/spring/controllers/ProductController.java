package ru.gik.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gik.spring.model.Product;
import ru.gik.spring.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.allProducts());
        return "products";
    }

    @GetMapping("/add")
    public String showForm() {
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit_product";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.editProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(productService.findById(id));
        return "redirect:/products";
    }
}
