package com.query.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebFluxSecurity
public class ResourceServerConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers("/graphql/**").access("hasAuthority('SCOPE_admin.write')").and()
				.oauth2ResourceServer().jwt().and();

		return http.build();
	}
}

