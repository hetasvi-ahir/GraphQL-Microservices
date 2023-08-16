package com.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@SpringBootApplication
public class GraphqlMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlMainApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
