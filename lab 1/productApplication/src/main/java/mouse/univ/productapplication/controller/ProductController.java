package mouse.univ.productapplication.controller;

import mouse.univ.productapplication.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/")
public class ProductController {
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return new Product(id, id+" name");
    }
}
