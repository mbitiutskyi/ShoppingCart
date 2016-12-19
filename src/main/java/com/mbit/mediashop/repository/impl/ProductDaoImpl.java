package com.mbit.mediashop.repository.impl;

import com.mbit.mediashop.model.Product;
import com.mbit.mediashop.repository.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mbitiutskyi.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void removeProduct(Product product) {
        entityManager.remove(product);
    }
}
