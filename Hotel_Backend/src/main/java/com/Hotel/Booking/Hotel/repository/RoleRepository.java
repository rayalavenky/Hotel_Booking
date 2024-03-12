package com.Hotel.Booking.Hotel.repository;

import com.Hotel.Booking.Hotel.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String role);

    boolean existsByName(Role role);
}
