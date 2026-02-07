package mys.linhnnt.mangham.lifecycle.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mys.linhnnt.mangham.lifecycle.entity.OrderDetail;
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
