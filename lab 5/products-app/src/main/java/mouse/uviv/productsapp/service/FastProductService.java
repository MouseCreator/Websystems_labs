package mouse.uviv.productsapp.service;

import mouse.uviv.productsapp.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Profile("default")
public class FastProductService implements ProductService{
    @Override
    public Optional<Product> getProduct(Long id, Long timeout) {
        return Optional.of(new Product(id, "Product " + id));
    }
}
