package com.Hotel.Booking.Hotel.exception;

public class RoleAlreadyExistException extends RuntimeException {
    public RoleAlreadyExistException(String message) {
        super(message);
    }
}
