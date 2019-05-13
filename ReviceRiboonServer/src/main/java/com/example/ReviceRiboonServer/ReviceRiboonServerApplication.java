package com.example.ReviceRiboonServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ReviceRiboonServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviceRiboonServerApplication.class, args);
	}


	@RequestMapping("/cs/{name}")
	public String sem(@PathVariable String name){
		return "6 semeter of"+name;
	}

}
