package com.ecommerce.cart.repository;

import com.ecommerce.cart.entity.CartItem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartRepository implements PanacheRepository<CartItem> {
}
