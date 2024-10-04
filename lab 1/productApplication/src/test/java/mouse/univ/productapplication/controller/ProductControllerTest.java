package mouse.univ.productapplication.controller;

import mouse.univ.productapplication.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    private ProductController productController;

    @BeforeEach
    void setup() {
        productController = new ProductController();
    }

    @Test
    void getProduct() {
        int expectedId = 10;
        Product product = productController.getProduct(expectedId);
        Long actualId = product.getId();
        assertEquals(expectedId, actualId);
    }
}