package mys.linhnnt.mangham.lifecycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import mys.linhnnt.mangham.lifecycle.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUserId(Long userId);
}
