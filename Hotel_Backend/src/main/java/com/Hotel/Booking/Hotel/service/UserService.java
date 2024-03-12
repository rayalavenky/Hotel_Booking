package com.Hotel.Booking.Hotel.service;

import com.Hotel.Booking.Hotel.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User registerUser(User user);
    List<User> getUsers();

    void deleteUser(String email);

    User getUser(String email);

}
