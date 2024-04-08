package com.tobeto.pair7Demo.service.dto.responses.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdUserResponse {
    private int id;
    private String firstName;

    private String lastName;

    private String email; //TODO mapperlarken contact ile yap

    private String password;
}
