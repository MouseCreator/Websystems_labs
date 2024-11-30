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
    private final RegularProductService productService;
    @Autowired
    public CacheableProductService(RegularProductService productService) {
        this.productService = productService;
    }

    @Cacheable(value = "products", key="#id")
    public Optional<Product> getProduct(Long id, Long timeout) {
        return productService.getProduct(id, timeout);
    }
}