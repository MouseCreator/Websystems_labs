package mouse.uviv.productsapp.service;

import mouse.uviv.productsapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductSupplier {
    public Optional<Product> getProduct(Long id, Long timeout) {
        Product product = new Product(id, "Product " + id);
        try {
            Thread.sleep(150 + timeout);
        } catch (InterruptedException e) {
            return Optional.empty();
        }
        return Optional.of(product);
    }
}
