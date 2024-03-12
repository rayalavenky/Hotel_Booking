package com.Hotel.Booking.Hotel.security;

import com.Hotel.Booking.Hotel.ServiceImpl.HotelUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author Simpson Alfred
 */
@Configuration
public class WebSecurityConfig extends SecurityConfigurerAdapter {
    @Autowired
    private HotelUserDetailsService userDetailsService;

    @Autowired
    private  JwtAuthEntryPoint jwtAuthEntryPoint;
    @Autowired
    private JwtUtilities jwtUtilities;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer :: disable)
                .exceptionHandling(
                        exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/rooms/**","/bookings/**","/users/**").permitAll()
                        .requestMatchers("/roles/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
       http.authenticationProvider(jwtUtilities.authenticationProvider());
        http.addFilterBefore(jwtUtilities.authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
