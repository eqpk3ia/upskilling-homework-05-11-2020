package com.example.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable("id") Long id) {
        Optional<User> result = userRepository.findById(id);

        return result.isPresent() ? result.get() : null;        
    }

    @PostMapping("/users")
    public User getAddUser(@RequestParam("fName") String fName, @RequestParam("lName") String lName,
            @RequestParam("email") String email, @RequestParam("phone") Long phone) {
        return userRepository.save(new User(fName, lName, email, phone));
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);

        return "User with Id" + id + "deleted";
    }

    @DeleteMapping("/users")
    public String deleteUsers() {
        userRepository.deleteAll();

        return "All Users are deleted";
    }

    @PatchMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestParam("fName") String fName,
            @RequestParam("lName") String lName, @RequestParam("email") String email,
            @RequestParam("phone") Long phone) {
                User updateUser = null;

        Optional<User> result = (Optional<User>) userRepository.findById(id);

        if (result.isPresent()) {
            updateUser = result.get();

            updateUser.setfName(fName);
            updateUser.setlName(lName);
            updateUser.setEmail(email);
            updateUser.setPhone(phone);

            updateUser = userRepository.save(updateUser);
        }

        return updateUser;        
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}