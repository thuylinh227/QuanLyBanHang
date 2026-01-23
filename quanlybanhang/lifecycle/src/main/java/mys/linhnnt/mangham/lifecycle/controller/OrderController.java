package mys.linhnnt.mangham.lifecycle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import mys.linhnnt.mangham.lifecycle.entity.Order;
import mys.linhnnt.mangham.lifecycle.service.OrderService;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(
            HttpSession session,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address) {

        try {
            Order order = orderService.checkout(session, name, phone, address);
            return ResponseEntity.ok(order);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
