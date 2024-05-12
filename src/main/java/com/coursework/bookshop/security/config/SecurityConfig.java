package com.coursework.bookshop.security.config;

import com.coursework.bookshop.security.filter.SignInRequestFilter;
import com.coursework.bookshop.security.handler.SignInSuccessHandler;
import com.coursework.bookshop.user.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Value("${app.api.path.author.getAuthors}")
    private String PATH_AUTHORS;

    @Value("${app.api.path.book.getBooks}")
    private String PATH_BOOKS;

    @Value("${security.app.authentication.cookie}")
    private String USER_COOKIE_CREDENTIALS;

    private final SignInSuccessHandler signInSuccessHandler;
    private final SignInRequestFilter signInRequestFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(PATH_BOOKS)
//                        .authenticated()

//                        .requestMatchers(PATH_AUTHORS)
//                        .hasAnyAuthority(Role.ADMIN.toString(), Role.MANAGER.toString())
//
//                        .requestMatchers(HttpMethod.DELETE)
//                        .hasAuthority(Role.ADMIN.toString())
//
//                        .requestMatchers(HttpMethod.POST)
//                        .hasAnyAuthority(Role.ADMIN.toString(), Role.MANAGER.toString())
//
                        .anyRequest()
                        .permitAll()


                )
                .sessionManagement(m->m.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .formLogin(form->form
                .loginPage("/signin")
                .successHandler(signInSuccessHandler)
        )
                .logout(logout->logout.logoutUrl("/exit").deleteCookies(USER_COOKIE_CREDENTIALS).logoutSuccessUrl("/loggedout"))
                .addFilterBefore(signInRequestFilter, UsernamePasswordAuthenticationFilter.class)
        ;
//                .formLogin(withDefaults());
//                .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
