package com.example.ss5_bai1.config;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.io.ClassPathResource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.example.ss5_bai1")
@PropertySource("classpath:hibernate.properties")
public class AppConfiguration {

    // =========================
    // JPA / HIBERNATE
    // =========================

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
            throws IOException {

        Properties properties = new Properties();

        try (InputStream inputStream =
                     new ClassPathResource("hibernate.properties")
                             .getInputStream()) {

            properties.load(inputStream);
        }

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setPackagesToScan(
                "com.example.ss5_bai1.model"
        );

        factory.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter()
        );

        factory.setJpaProperties(properties);

        return factory;
    }

    // =========================
    // TRANSACTION
    // =========================

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(
                entityManagerFactory
        );
    }

    // =========================
    // THYMELEAF
    // =========================

    @Bean
    public SpringResourceTemplateResolver templateResolver() {

        SpringResourceTemplateResolver resolver =
                new SpringResourceTemplateResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");

        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {

        SpringTemplateEngine engine =
                new SpringTemplateEngine();

        engine.setTemplateResolver(
                templateResolver()
        );

        return engine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {

        ThymeleafViewResolver resolver =
                new ThymeleafViewResolver();

        resolver.setTemplateEngine(
                templateEngine()
        );

        resolver.setCharacterEncoding("UTF-8");

        return resolver;
    }
}