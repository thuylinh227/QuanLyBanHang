package mys.linhnnt.mangham.lifecycle.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpSession;
import mys.linhnnt.mangham.lifecycle.entity.Order;
import mys.linhnnt.mangham.lifecycle.entity.OrderDetail;
import mys.linhnnt.mangham.lifecycle.entity.Product;
import mys.linhnnt.mangham.lifecycle.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    public Order checkout(HttpSession session,
                          String name,
                          String phone,
                          String address) {

        // Lấy cart từ session
        Map<Long, Integer> cart =
                (Map<Long, Integer>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // Tạo Order
        Order order = new Order();
        order.setCustomerName(name);
        order.setCustomerPhone(phone);
        order.setAddress(address);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(0); // 0 = chờ xử lý

        List<OrderDetail> orderDetails = new ArrayList<>();
        double totalPrice = 0;

        // Tạo OrderDetail
        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {

            Product product = productService.findById(entry.getKey());
            if (product == null) {
                throw new RuntimeException("Product not found");
            }

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity(entry.getValue());
            detail.setPrice(product.getPrice());

            totalPrice += product.getPrice() * entry.getValue();
            orderDetails.add(detail);
        }

        order.setTotalPrice(totalPrice);
        order.setOrderDetails(orderDetails);

        // Lưu order (OrderDetail sẽ tự lưu nhờ Cascade)
        Order savedOrder = orderRepository.save(order);

        // Xóa cart
        session.removeAttribute("cart");

        return savedOrder;
    }
}
