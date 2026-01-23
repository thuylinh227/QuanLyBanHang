package mys.linhnnt.mangham.lifecycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.linhnnt.mangham.lifecycle.dto.CartItemDTO;
import mys.linhnnt.mangham.lifecycle.entity.Cart;
import mys.linhnnt.mangham.lifecycle.entity.CartItem;
import mys.linhnnt.mangham.lifecycle.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        if (cart == null) {
            cart = cartService.createCart(userId);
        }
        return cart;
    }

    @PostMapping("/{cartId}/items")
    public CartItem addItem(
            @PathVariable Long cartId,
            @RequestBody CartItemDTO dto) {
        return cartService.addItem(cartId, dto.getProductId(), dto.getQuantity());
    }

    @GetMapping("/{cartId}/items")
    public List<CartItem> getItems(@PathVariable Long cartId) {
        return cartService.getItems(cartId);
    }
}
