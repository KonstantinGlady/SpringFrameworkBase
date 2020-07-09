package ru.gik.spring.hiber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gik.spring.hiber.model.Product;
import ru.gik.spring.hiber.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
     return    productRepository.findAll();
    }

    public  List<Product> findByCostLessThan(int i) {
        return productRepository.findByCostLessThan(i);
    }

    public List<Product> findByCostGreaterThan(int i) {
        return productRepository.findByCostGreaterThan(i);
    }

    public List<Product> greaterAndLessThan(Integer digMax, Integer digMin) {
            List<Product> products = null;
        if (digMin != null & digMax != null) {
            products = productRepository.greaterAndLessThan(digMax, digMin);
        } else if (digMax != null) {
            products = findByCostGreaterThan(digMax);
        } else if (digMin != null) {
            products = findByCostLessThan(digMin);
        }
        return products;
       // return productRepository.greaterAndLessThan(bigDig, smallDig);
    }
}
