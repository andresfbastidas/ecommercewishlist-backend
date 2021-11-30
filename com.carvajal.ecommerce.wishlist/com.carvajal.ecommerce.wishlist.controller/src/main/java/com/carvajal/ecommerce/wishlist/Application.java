package com.carvajal.ecommerce.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.carvajal")
@EnableJpaRepositories("com.carvajal.ecommerce.wishlist.persistence")
@EntityScan("com.carvajal")
public class Application {

	public static final String ENV_PATH = "com.carvajal.ecommerce.wishlist.home";

public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}

