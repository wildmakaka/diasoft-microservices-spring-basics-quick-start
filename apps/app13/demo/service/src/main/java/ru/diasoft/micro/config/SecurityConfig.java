package ru.diasoft.micro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

import ru.diasoft.micro.lib.config.OAuth2RequestInterceptor;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Value("${security.enabled:true}")
    private boolean securityEnabled;

    @Bean
    @Profile("!dev")
    public OAuth2RequestInterceptor oAuth2RequestInterceptor() {
        return new OAuth2RequestInterceptor();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if(securityEnabled) {
            http
                .csrf(CsrfConfigurer::disable)
                .authorizeRequests()
                .antMatchers("/", "/csrf", "/v3/api-docs", "/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**", "/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
        } else {
            http.authorizeRequests().antMatchers("/**").permitAll();
        }
    }
}