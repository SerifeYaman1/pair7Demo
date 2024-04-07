package com.tobeto.pair7Demo.controllers;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.abstacts.UserService;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.DeleteUserRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.UpdateUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.user.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetAllUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetByIdUserResponse;
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

    @GetMapping
    public List<GetAllUserResponse> getAll(){

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdUserResponse getById(int id){

        return userService.getById(id);
    }
    @PostMapping
    public AddUserResponse add(@RequestBody @Valid AddUserRequest request){

    return userService.add(request);
    }
    @PutMapping
    public void update(@RequestBody UpdateUserRequest request) {

        userService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestParam DeleteUserRequest request) {

        userService.delete(request);
    }


}
