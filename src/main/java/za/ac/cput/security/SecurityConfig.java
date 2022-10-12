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
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("Admin123"))
                .roles("ADMIN")
                .and()
                .withUser("Client")
                .password(encoder().encode("Client123"))
                .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
                        .and()
        .authorizeRequests()

                //Course endpoints
                .antMatchers(HttpMethod.POST,"course/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"course/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"course/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"course/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"course/getall").hasRole("ADMIN")

                //Lecturer endpoints
                .antMatchers(HttpMethod.POST,"lecturer/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"lecturer/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"lecturer/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"lecturer/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"lecturer/getall").hasRole("ADMIN")

                //University endpoints
                .antMatchers(HttpMethod.POST,"university/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"university/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"university/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"university/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"university/getall").hasRole("ADMIN")

                //Department endpoints
                .antMatchers(HttpMethod.POST,"department/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"department/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"department/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"department/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"department/getall").hasRole("ADMIN")

                //Enrollment endpoints
                .antMatchers(HttpMethod.POST,"enrollment/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"enrollment/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"enrollment/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"enrollment/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"enrollment/getall").hasRole("ADMIN")

                //Faculty endpoints
                .antMatchers(HttpMethod.POST,"faculty/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"faculty/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"faculty/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"faculty/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"faculty/getall").hasRole("ADMIN")

                //Student endpoints
                .antMatchers(HttpMethod.POST,"student/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"student/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"student/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"student/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"student/getall").hasRole("ADMIN")

                //Subject endpoints
                .antMatchers(HttpMethod.POST,"subject/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"subject/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"subject/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"subject/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"subject/getall").hasRole("ADMIN")

                //SystemAdmin endpoints
                .antMatchers(HttpMethod.POST,"systemadmin/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"systemadmin/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"systemadmin/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"systemadmin/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"systemadmin/getall").hasRole("ADMIN")

                //Test endpoints
                .antMatchers(HttpMethod.POST,"test/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"test/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"test/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"test/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"test/getall").hasRole("ADMIN")

                //Tutor endpoints
                .antMatchers(HttpMethod.POST,"tutor/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"tutor/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"tutor/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"tutor/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"tutor/getall").hasRole("ADMIN")

                .and()
                .formLogin().disable()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
