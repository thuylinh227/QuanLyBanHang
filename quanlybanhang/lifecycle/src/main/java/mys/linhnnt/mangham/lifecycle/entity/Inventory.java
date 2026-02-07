package mys.linhnnt.mangham.lifecycle.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "inventory")
public class Inventory {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToOne
@JoinColumn(name = "product_id", nullable = false, unique = true)
    private Long product;
@Column(nullable = false)
    private Integer quantity;
    public Long getId() {
        return id;
    }
    public Long getProduct() {
        return product;
    }
    public void setProduct(Long product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
