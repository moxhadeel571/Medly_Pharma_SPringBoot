package com.example.medly_pharma.medly_pharma_web_springboot.Configuration;

import com.example.medly_pharma.medly_pharma_web_springboot.Exception.GitHubSuccessHandler;
import com.example.medly_pharma.medly_pharma_web_springboot.Exception.YourCustomAuthenticationSuccessHandler;
import com.example.medly_pharma.medly_pharma_web_springboot.ServiceImplementation.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] WHITE_LABEL = {"/home", "/signin", "/logout","/register", "/saveUser", "/resource/**", "/static/**", "/templates/**"};

    @Autowired
    private YourCustomAuthenticationSuccessHandler successHandler;

    private GitHubSuccessHandler githubHandler;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired

    public SecurityConfig(GitHubSuccessHandler githubHandler) {
        this.githubHandler = githubHandler;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LABEL)
                                .permitAll()
                                .requestMatchers("/seller/**").hasRole("ADMIN")
                                .requestMatchers("/users/**").hasRole("USERS")
                                .anyRequest().authenticated()
                )

                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/signin")
                                .loginProcessingUrl("/userLogin")
                                .successHandler(successHandler)
                                .permitAll()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .loginPage("/signin")
                                .successHandler(githubHandler).permitAll()
                )
        ;

        return http.build();
    }
}
