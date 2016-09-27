package com.mbit.mediashop.repository;

import com.mbit.mediashop.model.Product;

import java.util.List;

/**
 * Created by mbitiutskyi on 17.09.2016.
 */
public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(int id);

    void updateProduct(Product product);

    void addProduct(Product product);

    void removeProduct(Product product);

}
