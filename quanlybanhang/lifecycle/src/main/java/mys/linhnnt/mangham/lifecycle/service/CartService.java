package mys.linhnnt.mangham.lifecycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mys.linhnnt.mangham.lifecycle.entity.Cart;
import mys.linhnnt.mangham.lifecycle.entity.CartItem;
import mys.linhnnt.mangham.lifecycle.repository.CartItemRepository;
import mys.linhnnt.mangham.lifecycle.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart createCart(Long userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        return cartRepository.save(cart);
    }

    public CartItem addItem(Long cartId, Long productId, Integer quantity) {
        CartItem item = new CartItem();
        item.setCartId(cartId);
        item.setProductId(productId);
        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }

    public List<CartItem> getItems(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }
}
