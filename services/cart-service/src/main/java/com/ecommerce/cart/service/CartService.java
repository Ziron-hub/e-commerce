package com.ecommerce.cart.service;

import com.ecommerce.cart.entity.CartItem;
import com.ecommerce.cart.repository.CartRepository;
import com.ecommerce.cart.kafka.CartEventProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CartService {

    @Inject
    CartRepository repository;

    @Inject
    CartEventProducer eventProducer;

    @Transactional
    public void addItem(CartItem item) {
        repository.persist(item);
        eventProducer.sendEvent("Item adicionado: " + item.productId);
    }

    @Transactional
    public void removeItem(Long productId, Long userId) {
        repository.delete("productId = ?1 AND userId = ?2", productId, userId);
        eventProducer.sendEvent("Item removido: " + productId + " do usuário " + userId);
    }

    public List<CartItem> listItems(Long userId) {
        return repository.listAll("userId", userId);
    }

    @Transactional
    public void clearCart(Long userId) {
        repository.deleteAll("userId", userId);
        eventProducer.sendEvent("Carrinho limpo para usuário " + userId);
    }
}
