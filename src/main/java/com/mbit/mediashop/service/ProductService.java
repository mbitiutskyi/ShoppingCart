package com.mbit.mediashop.service;

import com.mbit.mediashop.model.Product;

import java.util.List;

/**
 * Created by mbitiutskyi.
 */
public interface ProductService {

    List<Product> getProducts();

    Product getProductById(int id);

    void updateProduct(Product product);

    void addProduct(Product product);

    void removeProduct(Product product);
}
