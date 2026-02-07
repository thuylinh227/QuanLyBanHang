package mys.linhnnt.mangham.lifecycle.entity;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private String customerName;
    private String customerPhone;
    private String address;
    private double totalPrice;
    private int status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    // getter & setter
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public LocalDateTime getOrderDate() {return orderDate;}
    public void setOrderDate(LocalDateTime orderDate) {this.orderDate = orderDate;}
    public String getCustomerName() {return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public String getCustomerPhone() {return customerPhone;}
    public void setCustomerPhone(String customerPhone) {this.customerPhone = customerPhone;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}
    public List<OrderDetail> getOrderDetails() {return orderDetails;}
    public void setOrderDetails(List<OrderDetail> orderDetails) {this.orderDetails = orderDetails;}
}

