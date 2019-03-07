package com.indra.iopen.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class IOpenWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOpenWebAppInitializer.class);

    private Properties prop = null;

    @Override
    protected String[] getServletMappings() {
        // map dispatched servlet to '/'
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected void customizeRegistration(final Dynamic registration) {

        registration.setMultipartConfig(
                new MultipartConfigElement(
                        getProperties().getProperty("temp.file.path")));
    }

    private Properties getProperties() {
        if (prop == null) {
            prop = new Properties();

            try {
                final InputStream in = getClass().getResourceAsStream("/application.properties");
                prop.load(in);
                in.close();
            } catch (final IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return prop;
    }

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("spring.profiles.default",
                getProperties().getProperty("spring.profiles.default"));
        servletContext.setInitParameter("spring.profiles.active",
                getProperties().getProperty("spring.profiles.active"));
        super.onStartup(servletContext);
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new DelegatingFilterProxy("springSecurityFilterChain"),
        };
    }

}
