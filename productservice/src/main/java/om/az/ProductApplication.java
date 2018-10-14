package om.az;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ProductApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
