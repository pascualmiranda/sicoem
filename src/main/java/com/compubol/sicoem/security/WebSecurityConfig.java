package com.compubol.sicoem.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // Errores
            ,"/error/**"
            //Autentificación
            ,"/auth/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        //.requestMatchers("/error/**","/auth/**").permitAll()
                        .requestMatchers("/v1/usuarios/**").hasAuthority("ADMIN")
                        .requestMatchers("/v1/clientes/**").hasAnyAuthority("ADMIN","SUPER","CAJA")
                        .requestMatchers(HttpMethod.GET,"/v1/empenos/**").hasAnyAuthority("ADMIN","SUPER","CAJA")
                        .requestMatchers(HttpMethod.POST,"/v1/empenos").hasAnyAuthority("ADMIN","SUPER","CAJA")
                        .requestMatchers(HttpMethod.PUT, "/v1/empenos/**").hasAnyAuthority("ADMIN","SUPER")
                        .requestMatchers("/v1/garantias/**").hasAnyAuthority("ADMIN","SUPER","CAJA")
                        .requestMatchers(HttpMethod.GET,"/v1/movimientos/**").hasAnyAuthority("ADMIN","SUPER","CAJA")
                        .requestMatchers(HttpMethod.POST,"/v1/movimientos").hasAnyAuthority("ADMIN","SUPER","CAJA")
                        .requestMatchers(HttpMethod.PUT, "/v1/movimientos/**").hasAnyAuthority("ADMIN","SUPER")
                        .anyRequest().authenticated()
                )
                //.formLogin(withDefaults());
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
