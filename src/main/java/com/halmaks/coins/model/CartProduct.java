package com.halmaks.coins.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {
    private int id;
    private int cartId;
    private int productId;

    public CartProduct() {

    }

    public CartProduct(int cartId, int productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Column(name = "cart_id", nullable = false)
    public int getCartId() { return cartId; }
    public void setCartId(int cardId) {this.cartId = cardId; }

    @Column(name = "product_id", nullable = false)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    @Override
    public String toString() {
        return "Cart Product [id=" + id + "cart id=" + cartId +
                "product id=" + productId + "]";
    }
}
