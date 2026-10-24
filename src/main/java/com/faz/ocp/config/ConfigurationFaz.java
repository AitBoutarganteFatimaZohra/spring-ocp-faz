package com.faz.ocp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.faz.ocp.dao",
        "com.faz.ocp.metier"
})
public class ConfigurationFaz {
}