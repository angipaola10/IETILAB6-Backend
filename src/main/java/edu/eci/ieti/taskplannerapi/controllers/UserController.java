package edu.eci.ieti.taskplannerapi.controllers;

import edu.eci.ieti.taskplannerapi.persistence.PersistenseException;
import edu.eci.ieti.taskplannerapi.pojos.User;
import edu.eci.ieti.taskplannerapi.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    IUserServices us;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId){
        try {
            return new ResponseEntity<>(us.getUserById(userId), HttpStatus.ACCEPTED);
        } catch (PersistenseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            return new ResponseEntity<>(us.create(user), HttpStatus.CREATED);
        } catch (PersistenseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            return new ResponseEntity<>(us.update(user), HttpStatus.ACCEPTED);
        } catch (PersistenseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable String userId){
        try {
            us.remove(userId);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (PersistenseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
