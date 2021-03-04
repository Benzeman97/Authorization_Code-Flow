package com.benz.web.ui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
//@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.csrf().disable().authorizeRequests()
                .antMatchers("/","/public").permitAll()
                .anyRequest().authenticated().and().formLogin();*/

       http.csrf().disable().authorizeRequests().anyRequest()
               .permitAll();
    }
}
