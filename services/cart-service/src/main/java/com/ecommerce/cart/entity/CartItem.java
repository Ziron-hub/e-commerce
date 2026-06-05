package com.ecommerce.cart.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class CartItem extends PanacheEntity {
    public Long productId;
    public int quantity;
    
}
