package com.Hotel.Booking.Hotel.service;

import com.Hotel.Booking.Hotel.model.BookedRoom;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<BookedRoom> getAllBookingsByRoomId(Long roomId);

    List<BookedRoom> getAllBookings();

    BookedRoom findByBookingConfirmationCode(String confirmationCode);

    String saveBooking(Long roomId, BookedRoom bookingRequest);

    void cancelBooking(Long bookingId);
}
