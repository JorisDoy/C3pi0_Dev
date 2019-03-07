package com.indra.iopen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import com.indra.iopen.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static String ROLE_CLIENT = "CLIENT";

	private static String ROLE_EMPLOYEE = "EMPLOYEE";

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(authenticationProvider)
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/client/home", true)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .rememberMe()
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                .tokenValiditySeconds(2419200)
                .key("iopenkey")
                .and()
                .authorizeRequests()
                .antMatchers("/client/complaint/anonymous/hazard").permitAll()
                .antMatchers("/client/**").hasRole(ROLE_CLIENT)
                .antMatchers("/employee/**").hasRole(ROLE_EMPLOYEE)
                .anyRequest().permitAll()
                .and()
                .csrf()
                .disable();
        //for adding https to the selected pages
//			.and()
//				.requiresChannel()
//					.antMatchers("/newapplication").requiresSecure();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        super.configure(web);
    }

}
