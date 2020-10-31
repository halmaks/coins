package com.halmaks.coins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_photo")
public class ProductPhoto {
    private int id;
    private String url;
    private int productId;

    public ProductPhoto() {

    }

    public ProductPhoto(String url, int productId) {
        this.url = url;
        this.productId = productId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {return id;}
    public void setId(int id) {this.id = id; }

    @Column(name = "url", nullable = false)
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url; }

    @Column(name = "product_id", nullable = false)
    public int getProductId() { return productId; }

    @Column(name = "product_id", nullable = false)
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product photo [id=" + id +
                "url=" + url + "product id=" + productId + "]";
    }
}
