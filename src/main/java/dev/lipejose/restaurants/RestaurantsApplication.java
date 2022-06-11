package dev.lipejose.restaurants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RestaurantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantsApplication.class, args);
	}

	@GetMapping("/health")
	public String index(){
		return "i'm alive";
	}
}
