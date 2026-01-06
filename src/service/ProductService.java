package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    int save(Product product);
    int delete(Product product);
}
