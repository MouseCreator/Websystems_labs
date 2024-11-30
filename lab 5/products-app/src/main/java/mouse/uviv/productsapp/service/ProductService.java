package mouse.uviv.productsapp.service;

import mouse.uviv.productsapp.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProduct(Long id, Long timeout);
}
