package ru.gik.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gik.spring.model.Product;
import ru.gik.spring.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProducts() {
        return productRepository.allProducts();
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }

    public Product editProduct(Product product) {
        return productRepository.edit(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
