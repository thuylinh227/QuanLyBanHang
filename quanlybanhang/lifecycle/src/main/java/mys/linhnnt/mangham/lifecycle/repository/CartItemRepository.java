package mys.linhnnt.mangham.lifecycle.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import mys.linhnnt.mangham.lifecycle.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartId(Long cartId);
}
