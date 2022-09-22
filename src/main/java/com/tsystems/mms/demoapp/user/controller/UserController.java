package com.tsystems.mms.demoapp.user.controller;

import com.tsystems.mms.demoapp.user.dto.UserCreateCommand;
import com.tsystems.mms.demoapp.user.dto.UserInstanceItem;
import com.tsystems.mms.demoapp.user.dto.UserModifyCommand;
import com.tsystems.mms.demoapp.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful API controller for managing users.
 */
@RestController
@RequestMapping("/api/v1.0")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Finds all users.
     *
     * @return A list of users.
     */
    @GetMapping("/user")
    public ResponseEntity getUsers() {
        LOGGER.info("Get all users from the database");
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserInstanceItem> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserInstanceItem> createUser(@RequestBody UserCreateCommand command) {
        return new ResponseEntity<>(userService.createUser(command),HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<UserInstanceItem> modifyUser(@RequestBody UserModifyCommand command){
        UserInstanceItem dto = userService.modifyUser(command);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Implement response with success message
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("User with id: " + id + " deleted.",HttpStatus.OK);
    }
}