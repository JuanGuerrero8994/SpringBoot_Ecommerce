package com.jgdev.eccomerce.infraestructure.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.jgdev.eccomerce.domain.repository")
public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String url;


    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver") // Agregar explicitamente
                .url(url)
                .build();
    }
}