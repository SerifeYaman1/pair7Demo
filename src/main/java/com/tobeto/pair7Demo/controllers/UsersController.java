package com.tobeto.pair7Demo.controllers;

import com.tobeto.pair7Demo.service.abstacts.UserService;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
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

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll(){

        return userService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetByIdUserResponse getById(@PathVariable("id") int id){

        return userService.getById(id);
    }
    @PostMapping("/add")
    public AddUserResponse add(@RequestBody @Valid AddUserRequest request){

    return userService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequest request) {

        userService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {

        userService.delete(id);
    }


}
