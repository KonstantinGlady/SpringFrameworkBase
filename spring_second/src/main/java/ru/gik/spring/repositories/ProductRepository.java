package ru.gik.spring.repositories;

import org.springframework.stereotype.Component;
import ru.gik.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(234L, "item1", 333));
        products.add(new Product(235L, "item2", 335));
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("not found");
    }

    public void add(Product product) {
        products.add(product);
    }

    public Product delete(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.getId().equals(products.get(i).getId())) {
             return    products.remove(i);
            }
        }
        throw new RuntimeException("not found");
    }

    public Product edit(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.getId().equals(products.get(i).getId())) {
               return products.set(i, product);
            }
        }
        throw new RuntimeException("not found!");
    }
}
