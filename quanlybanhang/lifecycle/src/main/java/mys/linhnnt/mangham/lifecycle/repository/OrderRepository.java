package mys.linhnnt.mangham.lifecycle.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mys.linhnnt.mangham.lifecycle.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}

