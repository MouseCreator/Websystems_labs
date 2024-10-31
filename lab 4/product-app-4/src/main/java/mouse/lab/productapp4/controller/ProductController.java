package mouse.lab.productapp4.controller;

import lombok.AllArgsConstructor;
import mouse.lab.productapp4.dto.ProductCreateDTO;
import mouse.lab.productapp4.dto.ProductResponseDTO;
import mouse.lab.productapp4.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{id}")
    public ProductResponseDTO getProduct(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }
    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(ProductCreateDTO dto) {
        return productService.create(dto);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productService.remove(id);
    }

}
