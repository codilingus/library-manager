package pl.codilingus.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codilingus.library.BasicUser;
import pl.codilingus.library.User;
import pl.codilingus.library.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<BasicUser> getAllUsers(){
        return userRepository.getAllUsers().stream()
                .map(user -> new BasicUser(user.getFirstName(), user.getLastName()))
                .collect(Collectors.toList());
    }
}
