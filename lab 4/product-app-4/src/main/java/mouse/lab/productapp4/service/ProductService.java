package mouse.lab.productapp4.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import mouse.lab.productapp4.dto.ProductCreateDTO;
import mouse.lab.productapp4.dto.ProductResponseDTO;
import mouse.lab.productapp4.model.Product;
import mouse.lab.productapp4.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream().map(this::mapToResponse).toList();
    }
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found product by id: " + id));
        return mapToResponse(product);
    }

    private ProductResponseDTO mapToResponse(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName());
    }

    public ProductResponseDTO create(ProductCreateDTO createDTO) {
        Product product = new Product(null, createDTO.getName());
        Product saved = productRepository.save(product);
        return mapToResponse(saved);
    }

    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
