package za.ac.cput.security;

/*
SecurityConfig.java
Description: Holds the configuration for Web security in our application
Author: Mathew Fortuin
Date: 21/8/2022
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("Admin123"))
                .roles("ADMIN")
                .and()
                .withUser("Client")
                .password(encoder().encode("Client123"))
                .roles("USER");

        return (SecurityFilterChain) auth.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/[placeholder]/**/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/[placeholder]").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/[placeholder]/**/getall").hasRole("USER")
                .and()
                .formLogin().disable()
                .csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
