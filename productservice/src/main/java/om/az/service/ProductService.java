package om.az.service;

import lombok.extern.java.Log;
import om.az.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class ProductService {

private HashMap <Long, Product> productList = new HashMap();
private Long id = 0L;


    public Product getProduct(Long id) {
            return productList.get(id);
    }


    public Product addProduct(Product product) {
        id++;
        productList.put(id,product);
        product.setId(id);
        return product;
    }

    public  List<Product> getAllProducts() {
        return productList.values().stream().collect(Collectors.toList());

    }
}
