package com.Hotel.Booking.Hotel.controller;

import com.Hotel.Booking.Hotel.exception.RoleAlreadyExistException;
import com.Hotel.Booking.Hotel.model.Role;
import com.Hotel.Booking.Hotel.model.User;
import com.Hotel.Booking.Hotel.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all-roles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.FOUND);
    }

    @PostMapping("/create-new-row")
    public ResponseEntity<String> createRole(@RequestBody Role theRole){
       try{
           roleService.createRole(theRole);
           return ResponseEntity.ok("New role Created successfully");
       }catch(RoleAlreadyExistException e){
           return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

       }
    }

    @DeleteMapping("/delete/{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
    }

    @PostMapping("remove-all-users-from-role/{roleId}")
    public Role removeAllUsersFromRole(@PathVariable("roleId") Long roleId){
        return roleService.removeAllUsersFromRole(roleId);
    }
    @PostMapping("/remove-all-users-from-role")
    public User removeUserFromRole(@RequestParam("userId") Long userId,
                                   @RequestParam("roleId") Long roleId){
        return roleService.removeUserFromRole(userId, roleId);
    }
    @PostMapping("/assign-role-to-user")
    public User assignRoleToUser(@RequestParam("userId") Long userId,
                                   @RequestParam("roleId") Long roleId){
        return roleService.assignRoleToUser(userId, roleId);
    }
}