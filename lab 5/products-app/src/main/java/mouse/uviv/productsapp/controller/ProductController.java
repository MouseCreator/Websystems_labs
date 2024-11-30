package mouse.uviv.productsapp.controller;


import mouse.uviv.productsapp.dto.ProductResponseDTO;
import mouse.uviv.productsapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
    private final ProductService cacheableProductService;
    @Autowired
    public ProductController(ProductService cacheableProductService) {
        this.cacheableProductService = cacheableProductService;
    }
    @GetMapping("/products/{productId}")
    public ProductResponseDTO getProductById(@PathVariable Long productId,
                                             @RequestParam("timeout") Long timeout) {
        return cacheableProductService.getProduct(productId, timeout)
                .map(t -> new ProductResponseDTO(t.getId(), t.getName()))
                .orElseGet(()-> new ProductResponseDTO(null, "Unknown product"));
    }
}
