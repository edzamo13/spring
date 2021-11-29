package com.wiredbraincoffe.productapifunctional;

import com.wiredbraincoffe.productapifunctional.model.Product;
import com.wiredbraincoffe.productapifunctional.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProductApiFunctionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiFunctionalApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return bdd -> {

            Flux<Product> productFlux = Flux.just(
                            new Product(null, "Bit Latte", 2.99),
                            new Product(null, "Big Decaf", 2.99),
                            new Product(null, "Gree Tea", 2.99))
                    .flatMap(repository::save);
            productFlux.thenMany(repository.findAll())
                    .subscribe(System.out::println);
        };
    }
}
