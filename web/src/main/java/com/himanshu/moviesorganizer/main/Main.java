package com.himanshu.moviesorganizer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.himanshu.moviesorganizer.busines.spring.config.ConfigPropertiesLoader;
import com.himanshu.moviesorganizer.web.spring.config.MoviesOrganiserConfigurer;
import com.himanshu.moviesorganizer.web.spring.config.SecurityConfigurer;
import com.himanshu.moviesorganizer.web.spring.config.ThymeleafSpringConfig;

@SpringBootApplication
@EnableAutoConfiguration (exclude = {ThymeleafAutoConfiguration.class})
@ComponentScan(basePackages = { "com.himanshu.moviesorganizer.web.controller" })
@Import(value={ThymeleafSpringConfig.class, ConfigPropertiesLoader.class, SecurityConfigurer.class, MoviesOrganiserConfigurer.class})
public class Main {
  public static void main(String[] args) {
    SpringApplication sa = new SpringApplication(Main.class);
    sa.addListeners(new ApplicationPidFileWriter(System.getProperty("logs.dir") != null ? System.getProperty("logs.dir").concat("/application.pid") : Main.class.getResource("/").getFile().concat("/application.pid")));
    sa.run(args);
  }
}
