package com.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.board.dao",
        "com.board.service"})
public class ApplicationConfig {
}
