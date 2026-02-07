package mys.linhnnt.mangham.lifecycle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    // Bắt buộc phải có Constructor rỗng cho JPA
    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private List<User> users;
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}