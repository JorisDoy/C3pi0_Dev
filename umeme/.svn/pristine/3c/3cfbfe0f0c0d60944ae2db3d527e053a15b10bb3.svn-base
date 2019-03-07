package com.indra.iopen.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main Spring configuration class.
 * @author mbaez
 *
 */
@Configuration
@ComponentScan(
        basePackages = {
                "com.indra.iopen",
                "com.indra.iopen.service",
                "com.indra.iopen.util" },
        excludeFilters = {
                @Filter(
                        type = FilterType.ANNOTATION,
                        value = EnableWebMvc.class) })
@EnableJpaRepositories(
        basePackages = {
                "com.indra.iopen.repositories",
                "com.indra.iopen.repositories.model" })
@EnableTransactionManagement(
        mode = AdviceMode.PROXY)
@PropertySource({
	"classpath:application.properties",
	"classpath:mail.properties",
	"classpath:login.properties",
	"classpath:fileserver.properties",
"classpath:sms.properties" })
@Import(
		value = {
				MessageConfig.class,
				DatabaseConfig.class})

public class RootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Primary
    public MessageSource messageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }
}
