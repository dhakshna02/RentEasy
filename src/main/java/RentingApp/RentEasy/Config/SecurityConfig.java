package RentingApp.RentEasy.Config;// Ensure this is the correct package

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF protection
                .csrf(csrf -> csrf.disable())

                // 2. Define authorization rules
                .authorizeHttpRequests(auth -> auth
                        // List all public paths that anyone can access
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/Style.css",
                                "/app.js",
                                "/api/auth/**" // Allows access to signup and any future auth endpoints
                        ).permitAll()

                        // All other requests require the user to be authenticated
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}