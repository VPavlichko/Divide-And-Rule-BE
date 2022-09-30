package odium.dar.DarServer.controller;

import odium.dar.DarServer.model.User;
import odium.dar.DarServer.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
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

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> getUser(
            @PathVariable Long user_id) {

        User usr = userService.findUserById(user_id);

        return ResponseEntity.ok(usr);

    }

    @PostMapping(path = "/register",consumes = {"application/json"})
    public ResponseEntity<?> addUser(@RequestBody User user) {
        boolean userExists = userService.findUserByEmail(user.getEmail()).isPresent();
        if (userExists)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User found with the same email");
        User addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
}
