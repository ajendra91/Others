package com.example.ReviceRiboonClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ReviceRiboonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviceRiboonClientApplication.class, args);
	}


	@Autowired
	public RestTemplate rt;

	public String url="http://MCA/cs/";

	@RequestMapping("/deg/{name}")
	public String deg(@PathVariable String name){
		return rt.getForObject(url+name,String.class);

	}

	@LoadBalanced
	@Bean
	public RestTemplate fun(){
		return new RestTemplate();
	}

}
