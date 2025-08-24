package pl.coderslab.mvc.CookiesZad3;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProduktDao {

    public Product findById(Long id) {
        return getList().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getList() {
        return List.of(
                new Product(1l, "Product 1", 10.0),
                new Product(2l, "Product 2", 20.0),
                new Product(3l, "Product 3", 30.0),
                new Product(4l, "Product 4", 40.0),
                new Product(5l, "Product 5", 50.0)
        );
    }
}