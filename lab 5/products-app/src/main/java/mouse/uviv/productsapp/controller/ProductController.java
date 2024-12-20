package mouse.uviv.productsapp.controller;


import mouse.uviv.productsapp.dto.ProductResponseDTO;
import mouse.uviv.productsapp.profiles.ProfileManager;
import mouse.uviv.productsapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
    private final ProfileManager profileManager;
    private final ProductService cacheableProductService;
    @Autowired
    public ProductController(ProfileManager profileManager, ProductService cacheableProductService) {
        this.profileManager = profileManager;
        this.cacheableProductService = cacheableProductService;
    }
    @GetMapping("/products/{productId}")
    public ProductResponseDTO getProductById(@PathVariable Long productId,
                                             @RequestParam(name="timeout", defaultValue = "0") Long timeout) {
        profileManager.getActiveProfiles();
        return cacheableProductService.getProduct(productId, timeout)
                .map(t -> new ProductResponseDTO(t.getId(), t.getName()))
                .orElseGet(()-> new ProductResponseDTO(null, "Unknown product"));
    }
}
