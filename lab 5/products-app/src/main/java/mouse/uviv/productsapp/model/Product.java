package mouse.uviv.productsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = -7083520833945155660L;
    private Long id;
    private String name;
}
