package com.Hotel.Booking.Hotel.service;

import com.Hotel.Booking.Hotel.model.Role;
import com.Hotel.Booking.Hotel.model.User;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);

    Role findByName(String name);

    User removeUserFromRole(Long userId,Long roleId);

    User assignRoleToUser(Long userId,Long roleId);

    Role removeAllUsersFromRole(Long roleId);
}
