package com.Hotel.Booking.Hotel.repository;

import com.Hotel.Booking.Hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    Optional<User> findByEmail(String email);
}
