package mouse.uviv.productsapp.service;

import lombok.RequiredArgsConstructor;
import mouse.uviv.productsapp.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("no_cache")
@RequiredArgsConstructor
public class RegularProductService implements ProductService {
    private final ProductSupplier productSupplier;
    public Optional<Product> getProduct(Long id, Long timeout) {
        return productSupplier.getProduct(id, timeout);
    }
}
