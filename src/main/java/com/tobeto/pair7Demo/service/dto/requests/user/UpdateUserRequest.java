package com.tobeto.pair7Demo.service.dto.requests.user;

import com.tobeto.pair7Demo.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserType userType;
}
