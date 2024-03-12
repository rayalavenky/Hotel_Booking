package com.Hotel.Booking.Hotel.controller;

import com.Hotel.Booking.Hotel.model.User;
import com.Hotel.Booking.Hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.HttpStatus.FOUND;


/**
 * @author Simpson Alfred
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email){
        User theUser = userService.getUser(email);
        return ResponseEntity.ok(theUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String email){
        userService.deleteUser(email);
        return ResponseEntity.ok("User deleted successfully");
    }
}
