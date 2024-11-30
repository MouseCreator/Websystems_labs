package mouse.uviv.productsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProductResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4757003932082587490L;
    private Long id;
    private String name;
}
