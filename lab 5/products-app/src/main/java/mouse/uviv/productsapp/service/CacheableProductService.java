package mouse.uviv.productsapp.service;

import mouse.uviv.productsapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile({"map_cache", "caffeine_cache"})
public class CacheableProductService implements ProductService {
    private final ProductSupplier productSupplier;
    @Autowired
    public CacheableProductService(ProductSupplier productSupplier) {
        this.productSupplier = productSupplier;
    }

    @Cacheable(value = "products", key="#id")
    public Optional<Product> getProduct(Long id, Long timeout) {
        return productSupplier.getProduct(id, timeout);
    }
}