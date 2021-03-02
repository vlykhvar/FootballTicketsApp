package com.dev.football.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/register").permitAll()
                .antMatchers(HttpMethod.GET, "/stadiums").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/stadiums").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/games").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/game-sessions").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/game-sessions/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/orders").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/orders/complete").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/shopping-carts/game-sessions").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/shopping-carts/by-user").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/users/by-email").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().httpBasic()
                .and().csrf().disable();

    }
}
