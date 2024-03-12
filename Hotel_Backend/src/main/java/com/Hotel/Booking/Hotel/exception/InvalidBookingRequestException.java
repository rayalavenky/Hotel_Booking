package com.Hotel.Booking.Hotel.exception;

public class InvalidBookingRequestException extends RuntimeException{
    public InvalidBookingRequestException(String message) {
        super(message);
    }
}
