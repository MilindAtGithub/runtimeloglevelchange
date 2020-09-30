package com.milind.sl4jpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Sl4jpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sl4jpocApplication.class, args);
	}


}
