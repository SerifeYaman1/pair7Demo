package com.tobeto.pair7Demo.controllers;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.abstacts.UserService;
import com.tobeto.pair7Demo.service.dto.requests.UserAddRequest;
import com.tobeto.pair7Demo.service.dto.responses.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.UserListingResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/getAll")
    public List<UserListingResponse>  getAll(){

        return userService.getAll();
    }

    @GetMapping("/users/getById")
    public User getById(int id){

        return userService.getById(id);
    }
    @PostMapping
    public AddUserResponse add(@RequestBody @Valid UserAddRequest request){

return userService.add(request);
    }
    @PutMapping
    public void update(@RequestBody User user) {

        userService.update(user);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {

        userService.delete(id);
    }


}
