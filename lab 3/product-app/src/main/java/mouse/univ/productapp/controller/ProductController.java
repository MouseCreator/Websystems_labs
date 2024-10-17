package mouse.univ.productapp.controller;

import lombok.AllArgsConstructor;
import mouse.univ.productapp.dto.ProductCreateDTO;
import mouse.univ.productapp.model.Product;
import mouse.univ.productapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(ProductCreateDTO dto) {
        return productService.create(dto);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
         productService.remove(id);
    }

}

