package jp.co.sakura.auth.config;

import jp.co.sakura.auth.filter.AccessAuthenticationProvider;
import jp.co.sakura.auth.handler.AccessAuthenticationFailureHandler;
import jp.co.sakura.auth.handler.AccessAuthenticationSuccessHandler;
import jp.co.sakura.core.constant.AuthConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessAuthenticationSuccessHandler accessAuthenticationSuccessHandler;

    @Autowired
    private AccessAuthenticationFailureHandler accessAuthenticationFailureHandler;

    @Autowired
    private AccessAuthenticationProvider accessAuthenticationProvider;

    @Autowired
    private UserDetailsService authUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/login", "/auth/login", "/registration", "/auth/registration", "/logout", "/error")
                .permitAll()
                .anyRequest()
                .authenticated();
        http.headers()
                .cacheControl();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/")
                .failureUrl("/error")
                .usernameParameter(AuthConstant.PARAM_USERNAME)
                .passwordParameter(AuthConstant.PARAM_PASSWORD)
                .successHandler(accessAuthenticationSuccessHandler)
                .failureHandler(accessAuthenticationFailureHandler);
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(accessAuthenticationProvider);
        auth.userDetailsService(authUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
