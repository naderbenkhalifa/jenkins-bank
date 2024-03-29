package com.benkhalifa.ICINBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
@SpringBootApplication
public class IcinBankApplication {
	
	@RequestMapping("/hello")
	  public String home() {
	    return "Hello Docker world";
	  }

	public static void main(String[] args) {
		SpringApplication.run(IcinBankApplication.class, args);
	}

}
