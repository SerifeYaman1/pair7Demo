package com.tobeto.pair7Demo.service.dto.requests.user;

import com.tobeto.pair7Demo.entities.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AddUserRequest {
    private String firstName;

    private String lastName;

    private String email; //TODO mapperlarken contact ile yap

    private String password;

    private UserType userType;
}
