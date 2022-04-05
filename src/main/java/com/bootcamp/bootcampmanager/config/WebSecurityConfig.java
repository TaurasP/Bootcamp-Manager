package com.bootcamp.bootcampmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/css/**").permitAll()
                .antMatchers( "/js/**").permitAll()
                /*.antMatchers("/index").hasAnyRole("ADMIN", "LECTURER", "STUDENT")*/
                .antMatchers("/bootcamps").hasRole("ADMIN")
                .antMatchers("/courses").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
                .antMatchers("/tasks").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers("/groups").hasAnyRole("ADMIN")
                .antMatchers("/students").hasAnyRole("LECTURER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
    }
}
