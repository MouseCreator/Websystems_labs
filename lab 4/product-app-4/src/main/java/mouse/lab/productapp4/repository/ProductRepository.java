package mouse.lab.productapp4.repository;

import mouse.lab.productapp4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
