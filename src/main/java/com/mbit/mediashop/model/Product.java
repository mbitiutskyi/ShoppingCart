package com.mbit.mediashop.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mbitiutskyi.
 */

@Entity
@Table(name = "product")
public class Product implements Serializable{

    private static final long serialVersionUID = 6196625833449010930L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category")
    private Category category;
    @Column(name = "genre")
    private String genre;
    @Column(name = "name")
    private String name;
    @Column(name = "price", precision = 12, scale = 2)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
