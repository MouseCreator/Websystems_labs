package mouse.uviv.productsapp.service;

import lombok.extern.log4j.Log4j2;
import mouse.uviv.productsapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile({"redis"})
@Log4j2
public class RedisProductService implements ProductService {
    private final ProductSupplier productSupplier;
    @Autowired
    public RedisProductService(ProductSupplier productSupplier) {
        this.productSupplier = productSupplier;
    }

    @Cacheable(value = "products", key="#id")
    public Optional<Product> getProduct(Long id, Long timeout) {
        log.info("[!CACHE] Accessing product with id " + id);
        return productSupplier.getProduct(id, timeout);
    }
}
