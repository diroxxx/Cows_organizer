package com.example.cows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
//                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login","/register", "/errors").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/owner-panel").hasRole("OWNER")
                                .anyRequest().authenticated()
                        )
                .csrf(csrf -> csrf.disable()) // 🔥 H2 Console wymaga wyłączenia CSRF
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // 🔥 Pozwala na wyświetlenie H2 w `<iframe>`

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/owner-panel", true)
                        .failureUrl("/login?error=true")
                        .permitAll())
//
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login").defaultSuccessUrl("/owner-panel", true))

                .logout(logout -> logout
//                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID")
                        .permitAll());

        return http.build();
    }


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
