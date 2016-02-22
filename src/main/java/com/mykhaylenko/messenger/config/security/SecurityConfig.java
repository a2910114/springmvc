package com.mykhaylenko.messenger.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by pavlo.mykhaylenko on 8/20/2015.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MessengerUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/messages").hasAuthority("ROLE_ADMIN") //==.antMatchers("/messages").access("hasRole('ROLE_SPITTER')")
                .anyRequest().permitAll()
            .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
            .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200) //4 weeks
                    .key("messenger")
            .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .permitAll()
                    .logoutSuccessUrl("/")
            .and()
                .csrf().csrfTokenRepository(csrfTokenRepository())
            .and()
                .httpBasic();
//            .and()
//                .requiresChannel()
//                .antMatchers("/messenger/registration").requiresSecure();
                //.and()
//                .httpBasic();
    }

    //    /**
    //     * Used for configuration users that have access to the web app
    //     * all users stored like an in memory objects
    //     * @param auth
    //     * @throws Exception
    //     */
    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //        auth
    //            .inMemoryAuthentication()
    //                .withUser("user").password("password").roles("USER").and()
    //                .withUser("admin").password("password").roles("USER").roles("ADMIN");
    //    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public ShaPasswordEncoder passwordEncoder() {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);

        return  encoder;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
}
