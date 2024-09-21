package mouse.univ.productapplication.controller;

import mouse.univ.productapplication.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return new Product(id, id+" name");
    }
    @PostMapping("/{id}")
    public Product postProduct(@PathVariable("id") long id) {
        return new Product(id, id+" name");
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") long id) {
        return new Product(id, id+" name");
    }
}
