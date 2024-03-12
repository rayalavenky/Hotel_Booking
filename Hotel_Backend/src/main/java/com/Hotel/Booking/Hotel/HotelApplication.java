package com.Hotel.Booking.Hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
}
