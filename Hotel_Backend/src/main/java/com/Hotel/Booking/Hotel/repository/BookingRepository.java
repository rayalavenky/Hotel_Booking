package com.Hotel.Booking.Hotel.repository;

import com.Hotel.Booking.Hotel.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookedRoom,Long> {

    Optional<BookedRoom> findByBookingConfirmationCode(String confirmationCode);
    List<BookedRoom> findByRoomId(Long roomId);
}
