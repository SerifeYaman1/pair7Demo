package com.tobeto.pair7Demo.service.dto.requests.user;

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
    @NotBlank(message = "Kullanıcı adı ve soyadı boş bırakılmamalı.")
    @Size(min = 3,max = 20)
    private String firstName;
    private String lastName;
}
