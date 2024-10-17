package com.argus.ecommerce.config;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
*/

import java.util.*;

//@Configuration
public class SecurityConfig {

    /*
     * @Bean
     * public PasswordEncoder passwordEncoder() {
     * return new BCryptPasswordEncoder();
     * }
     * 
     * @Bean
     * UserDetailsService userDetailsService() {
     * var user =
     * User.withUsername("ikurce").password("123456").authorities("read").build();
     * return new InMemoryUserDetailsManager(user);
     * }
     * 
     * @Bean
     * public InMemoryUserDetailsManager userDetailService() {
     * UserDetails admin = User.withUsername("admin")
     * .password(passwordEncoder().encode("adminpass"))
     * .roles("ADMIN")
     * .build();
     * 
     * UserDetails user1 = User.withUsername("user1")
     * .password(passwordEncoder().encode("user1Pass"))
     * .roles("USER")
     * .build();
     * 
     * return new InMemoryUserDetailsManager(admin);
     * }
     * 
     * @Bean
     * public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws
     * Exception {
     * // httpSecurity.formLogin(form -> form.loginPage("/login").permitAll());
     * 
     * httpSecurity.authorizeHttpRequests(request -> request
     * .requestMatchers("/blog/**").permitAll()
     * .requestMatchers(HttpMethod.POST, "/customers/create").hasRole("ADMIN")
     * .requestMatchers(HttpMethod.GET, "/customers/customerAll").hasRole("USER")
     * .requestMatchers(HttpMethod.PUT, "/customers/updateCustomer").hasRole("USER")
     * .requestMatchers(HttpMethod.GET,
     * "/customers/deleteCustomer/**").hasRole("ADMIN"));
     * 
     * // use HTTP Basic Authentication
     * // httpSecurity.httpBasic(Customizer.withDefaults());
     * 
     * // disable Cross Site Request Forgery (CSFR)
     * // in general not required for stateles rest apıs that use post,
     * // put delete and/or patch
     * 
     * // httpSecurity.csrf(csfr -> csfr.disable());
     * 
     * return httpSecurity.build();
     * }
     */
}
