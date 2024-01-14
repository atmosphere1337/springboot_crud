package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;






@RestController
public class Controller {
	@GetMapping("/")
	public String index() {
		return "Grettings from Spring boot";
	}

}
