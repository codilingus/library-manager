package pl.codilingus.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codilingus.library.BasicUser;
import pl.codilingus.library.User;
import pl.codilingus.library.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/basicInformation")
    public List<BasicUser> getAllUsersWithBasicInformation(){
        return userRepository.getAllUsers().stream()
                .map(user -> new BasicUser(user.getFirstName(), user.getLastName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/users")
    public List<User> getAllUsersWithFullInformation(){
        return userRepository.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userRepository.findUserById(id);
    }

    @PostMapping("/users/fullInformation")
    public ResponseEntity addUser(@RequestBody User user){
        userRepository.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/users/fullInformation/{id}")
    public ResponseEntity editUser(@RequestBody User user ,@PathVariable int id){
        userRepository.editUser(user , id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/users/fullInformation/{id}")
    public void deleteUser(int id){
        userRepository.deleteUser(id);
    }

}
