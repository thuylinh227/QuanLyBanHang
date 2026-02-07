package mys.linhnnt.mangham.lifecycle.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.linhnnt.mangham.lifecycle.dto.CartItemDTO;
import mys.linhnnt.mangham.lifecycle.entity.Cart;
import mys.linhnnt.mangham.lifecycle.service.CartService;
@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService service;
    public CartController(CartService service) {
        this.service = service;
    }
    @PostMapping
    public Cart createCart() {
        return service.createCart();
    }
    @PostMapping("/{cartId}/items")
    public Cart addItem(@PathVariable Long cartId,
                        @RequestBody CartItemDTO dto) {
        return service.addItemToCart(cartId, dto);
    }
}
