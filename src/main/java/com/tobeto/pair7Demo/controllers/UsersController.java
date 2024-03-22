package com.tobeto.pair7Demo.controllers;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

   private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping
    public void add(@RequestBody User user){
        userRepository.save(user);
    }
    @PutMapping
    public void update(@RequestBody User user)
    {
        userRepository.save(user);
    }

    @DeleteMapping
    public void delete(@RequestParam int id)
    {
        User user = userRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Kullanıcı Bulunamadı."));
        userRepository.delete(user);
    }
}
