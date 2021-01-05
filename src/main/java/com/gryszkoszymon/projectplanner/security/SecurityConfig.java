package com.gryszkoszymon.projectplanner.security;

import com.gryszkoszymon.projectplanner.security.oauth2.CustomOAuth2User;
import com.gryszkoszymon.projectplanner.security.oauth2.CustomOAuth2UserService;
import com.gryszkoszymon.projectplanner.security.oauth2.OAuth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;
    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth2/**", "/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and().successHandler(oAuth2LoginSuccessHandler)
                .and().logout().permitAll();
    }
}
