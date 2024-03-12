package com.Hotel.Booking.Hotel.ServiceImpl;

import com.Hotel.Booking.Hotel.exception.UserAlreadyExistsException;
import com.Hotel.Booking.Hotel.model.Role;
import com.Hotel.Booking.Hotel.model.User;
import com.Hotel.Booking.Hotel.repository.RoleRepository;
import com.Hotel.Booking.Hotel.repository.UserRepository;
import com.Hotel.Booking.Hotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  RoleRepository roleRepository;
    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String email) {
        User theUser = getUser(email);
        if (theUser != null){
            userRepository.deleteByEmail(email);
        }

    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}