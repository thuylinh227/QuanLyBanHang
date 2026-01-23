package mys.linhnnt.mangham.lifecycle.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mys.linhnnt.mangham.lifecycle.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
