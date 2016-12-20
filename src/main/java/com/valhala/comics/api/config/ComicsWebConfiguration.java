package com.valhala.comics.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.valhala.comics")
public class ComicsWebConfiguration {

} // fim do classe ComicsWebConfiguration