package com.himanshu.moviesorganizer.web.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication paramAuthentication) throws AuthenticationException {
    if (((String)paramAuthentication.getPrincipal()).equalsIgnoreCase("user") && ((String)paramAuthentication.getCredentials()).equalsIgnoreCase("user")) {
      List<GrantedAuthority> permissions = new ArrayList<>();
      permissions.add(new SimpleGrantedAuthority("ROLE_USER"));
      return new UsernamePasswordAuthenticationToken(paramAuthentication.getPrincipal(), paramAuthentication.getCredentials(), permissions);
    }
    return null;
  }

  @Override
  public boolean supports(Class<?> paramClass) {
    return true;
  }

}
