package om.az.controler;

import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import om.az.api.ProductApi;
import om.az.api.model.Product;
import om.az.model.Discount;
import om.az.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-18T15:26:19.614+02:00")

@Controller
@Log
public class ProductController implements ProductApi {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductService productService;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public  ResponseEntity<Product> addProduct(@ApiParam(value = "product to add to the store" , required=true )
    @Valid @RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getProduct(@ApiParam(value = "productId",required=true) @PathVariable("productId") Long productID) {

        Product product = productService.getProduct(productID);
        if(product != null) {
            log.info("weatherDataweatherDataweatherDataweatherDataweatherDataweatherDataweatherDataweatherData s " + productID);
//          Discount discount = restTemplate.getForObject("http://localhost8091/discount/"+productID,Discount.class);
            Discount discount = restTemplate.getForObject("http://discountservice:8091/discount/"+ productID, Discount.class);
            log.info("weatherDataweatherDataweatherDataweatherDataweatherDataweatherDataweatherDataweatherData" + discount);
            if(discount != null) {
                product.setFormerPrice(product.getPrice());
                product.setPrice(discount.getPrice());
            }
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> geAllProduct() {
     List<Product> productList=  productService.getAllProducts();
        return new ResponseEntity<List<Product>>( productList, HttpStatus.OK);
    }
}
