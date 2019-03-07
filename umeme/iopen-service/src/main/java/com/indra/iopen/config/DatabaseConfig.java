package com.indra.iopen.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DatabaseConfig {

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	@Autowired
	private Environment env;

	@Bean(destroyMethod = "close")
	public BasicDataSource dataSourcePool() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		ds.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		ds.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		ds.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		ds.setInitialSize(5);
		return ds;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
			final JpaVendorAdapter jpaVendorAdapter) {
		final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		return emfb;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean
	@Profile("dev")
	public HibernateJpaVendorAdapter jpaVendorAdapterDev() {
		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.ORACLE);
		// adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		// adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.Oracle8iDialect");
		// adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		return adapter;
	}

	@Bean
	@Profile("prod")
	public HibernateJpaVendorAdapter jpaVendorAdapterProd() {
		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.ORACLE);
		adapter.setShowSql(false);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.Oracle8iDialect");
		return adapter;
	}

	@Bean
	public JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return new JpaTransactionManager();
	}
}
