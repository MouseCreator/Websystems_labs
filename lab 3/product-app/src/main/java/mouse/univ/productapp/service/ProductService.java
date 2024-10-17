package mouse.univ.productapp.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import mouse.univ.productapp.dto.ProductCreateDTO;
import mouse.univ.productapp.model.Product;
import mouse.univ.productapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Not found product by id: " + id));
    }

    public Product create(ProductCreateDTO createDTO) {
        Product product = new Product(null, createDTO.getName());
        return productRepository.save(product);
    }

    public void remove(Long id) {
        productRepository.deleteById(id);
    }

}
