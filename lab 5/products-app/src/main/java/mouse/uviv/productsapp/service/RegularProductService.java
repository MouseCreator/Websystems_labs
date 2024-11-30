package mouse.uviv.productsapp.service;

import mouse.uviv.productsapp.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("no_cache")
public class RegularProductService implements ProductService {
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
