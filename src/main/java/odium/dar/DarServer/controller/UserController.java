package odium.dar.DarServer.controller;

import odium.dar.DarServer.models.User;
import odium.dar.DarServer.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping(path = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
}
