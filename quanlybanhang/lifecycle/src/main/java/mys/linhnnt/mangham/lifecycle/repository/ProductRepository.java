package mys.linhnnt.mangham.lifecycle.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mys.linhnnt.mangham.lifecycle.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Không cần viết gì cả, Spring đã tự làm hết các hàm CRUD cơ bản
}