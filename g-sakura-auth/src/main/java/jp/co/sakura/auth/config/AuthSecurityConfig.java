package jp.co.sakura.auth.config;

import jp.co.sakura.auth.handler.AccessAuthenticationFailureHandler;
import jp.co.sakura.auth.handler.AccessAuthenticationSuccessHandler;
import jp.co.sakura.core.constant.AuthConstant;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AccessAuthenticationSuccessHandler accessAuthenticationSuccessHandler;

    @Resource
    private AccessAuthenticationFailureHandler accessAuthenticationFailureHandler;

    @Override
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/login", "/auth/login", "/registration", "/auth/registration")
                .permitAll()
                .anyRequest()
                .authenticated();
        http.headers()
                .cacheControl();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/login")
                .usernameParameter(AuthConstant.PARAM_USERNAME)
                .passwordParameter(AuthConstant.PARAM_PASSWORD)
                .successHandler(accessAuthenticationSuccessHandler)
                .failureHandler(accessAuthenticationFailureHandler)
                .successForwardUrl("/");
        http.exceptionHandling();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
