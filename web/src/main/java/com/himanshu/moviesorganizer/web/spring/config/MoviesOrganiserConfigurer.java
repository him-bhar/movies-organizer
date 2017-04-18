package com.himanshu.moviesorganizer.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import com.himanshu.moviesorganizer.web.spring.security.CustomAuthProvider;

@Configuration
public class MoviesOrganiserConfigurer {
  
  @Bean
  public AuthenticationProvider authProvier() {
    return new CustomAuthProvider();
  }
  

}
