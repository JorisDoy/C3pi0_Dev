package com.indra.iopen.config;

import java.util.Properties;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.indra.iopen.service.phone.SMSServiceSoapMockImpl;

import umemesmsservice.SMSServiceSoap;

@Configuration
@EnableAsync
public class MessageConfig {

	@Autowired
	private Environment env;

	@Bean
	//	@Profile("dev")
	//	public JavaMailSender mailSenderDevelopment() {
	//		final JavaMailSenderToFile mailSender = new JavaMailSenderToFile();
	//		mailSender.setMailDestinationFolder(env.getProperty("mail.generated.folder"));
	//		return mailSender;
	//	}
	//
	//	@Bean
	//	@Profile("prod")
	public JavaMailSender mailSenderProduction() {

		final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getRequiredProperty("mail.host"));
		mailSender.setPort(Integer.valueOf(env.getRequiredProperty("mail.port")));
		mailSender.setUsername(env.getRequiredProperty("mail.username"));
		mailSender.setPassword(env.getRequiredProperty("mail.password"));
		final Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		mailSender.setJavaMailProperties(properties);
		return mailSender;

	}

	@Bean
	public VelocityEngineFactoryBean velocityEngine() {
		final VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();

		final Properties props = new Properties();
		props.setProperty("resource.loader", "class");
		props.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.setVelocityProperties(props);

		return velocityEngine;
	}

	@Bean
	@Profile("dev")
	public SMSServiceSoap smsServiceDevelopment() {
		return new SMSServiceSoapMockImpl();
	}

	@Bean
	@Profile("prod")
	public SMSServiceSoap smsServiceProduction() {
		final String endpoint = env.getProperty("sms.service.endpoint");
		final JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(SMSServiceSoap.class);
		factory.setAddress(endpoint);
		final SMSServiceSoap smsServiceSoap = (SMSServiceSoap) factory.create();
		configHttpConduit(smsServiceSoap);
		return smsServiceSoap;
	}

	/**
	 * not advised for production but the soap service throws the following
	 * error otherwise: The https URL hostname does not match the Common Name
	 * (CN) on the server certificate. To disable this check (NOT recommended
	 * for production) set the CXF client TLS configuration property
	 * "disableCNCheck" to true.
	 *
	 * @param service
	 */
	private void configHttpConduit(Object service) {
		final Client clientProxy = ClientProxy.getClient(service);

		final HTTPConduit conduit = (HTTPConduit) clientProxy.getConduit();
		final String targetAddr = conduit.getTarget().getAddress().getValue();
		if (targetAddr.toLowerCase().startsWith("https:")) {
			final TrustManager[] simpleTrustManager = new TrustManager[] { new X509TrustManager() {
				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} };
			final TLSClientParameters tlsParams = new TLSClientParameters();
			tlsParams.setTrustManagers(simpleTrustManager);
			tlsParams.setDisableCNCheck(true);
			tlsParams.setSecureSocketProtocol("SSL"); // This line is not very
			// necessary.
			conduit.setTlsClientParameters(tlsParams);

		}
	}

}
