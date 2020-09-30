package com.milind.sl4jpoc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Configuration
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //http.authorizeRequests().anyRequest().permitAll()
            //        .and().csrf().disable();
            http.csrf().ignoringAntMatchers("/actuator/**");
        }
    }
}
