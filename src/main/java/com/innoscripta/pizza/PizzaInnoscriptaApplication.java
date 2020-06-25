package com.innoscripta.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.innoscripta.pizza.entity","com.innoscripta.pizza.config"})
public class PizzaInnoscriptaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaInnoscriptaApplication.class, args);
	}

}
