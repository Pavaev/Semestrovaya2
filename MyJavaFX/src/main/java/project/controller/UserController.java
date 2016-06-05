package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import project.model.User;
import project.service.IUserService;

import java.util.List;

/**
 * Created by Daniel Shchepetov on 11.05.2016.
 */
@RestController
public class UserController {


    @Autowired
    IUserService userServ;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Integer id) {

        if (!userServ.isExist(id) || id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userServ.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServ.getUsers();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(userServ.getUsers(), HttpStatus.OK);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder builder) {

        if (userServ.isExist(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        user = userServ.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {

        User us = userServ.getUserById(id);

        if (us == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userServ.updateUser(us, user), HttpStatus.OK);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {

        if (!userServ.isExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userServ.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllUsers() {

        userServ.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
