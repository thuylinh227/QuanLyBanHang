package mys.linhnnt.mangham.lifecycle.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mys.linhnnt.mangham.lifecycle.dto.ProductDTO;
import mys.linhnnt.mangham.lifecycle.entity.Product;
import mys.linhnnt.mangham.lifecycle.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy danh sách sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
    return productRepository.findById(id).orElse(null);
    }

    // Tạo sản phẩm mới (Logic chính nằm ở đây)
    public Product createProduct(ProductDTO productDTO) {
        // Validation đơn giản
        if (productDTO.getPrice() < 0) {
            throw new RuntimeException("Giá tiền không được âm!");
        }

        // Chuyển đổi từ DTO sang Entity
        Product newProduct = new Product(productDTO.getName(), productDTO.getPrice());
        
        // Lưu vào DB
        return productRepository.save(newProduct);
    }
}
