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
                .antMatchers("/bootcamps").hasRole("ADMIN")
                .antMatchers("/bootcamp").hasRole("ADMIN")
                .antMatchers("/tasks").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
                .antMatchers("/task").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers("/user").hasRole("ADMIN")
                .antMatchers("/students").hasRole("LECTURER")
                .antMatchers("/student").hasRole("LECTURER")
                // .antMatchers("/groups").hasAnyRole("ADMIN", "LECTURER")
                // .antMatchers("/group").hasAnyRole("ADMIN", "LECTURER")
                // .antMatchers("/courses").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
                // .antMatchers("/course").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
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
