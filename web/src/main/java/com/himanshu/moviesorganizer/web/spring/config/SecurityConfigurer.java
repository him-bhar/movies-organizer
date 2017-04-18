package com.himanshu.moviesorganizer.web.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private AuthenticationProvider customAuthProvider;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .formLogin()
    .and()
    .logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("true")
    .and()
    .authorizeRequests()
      .antMatchers("/greeting", "/greeting/**").authenticated()
    .and()
    .httpBasic()
    .and()
    .csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    auth.authenticationProvider(customAuthProvider);
  }
  
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
