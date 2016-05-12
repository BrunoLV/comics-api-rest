package com.valhala.comics.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classes de configuração spring da layer Web da aplicação.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.valhala.comics")
public class ComicsWebConfiguration {
}
