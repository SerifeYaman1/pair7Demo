package com.tobeto.pair7Demo.service.mapper;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.user.AddUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userFromAddRequest(AddUserRequest request);

    AddUserResponse userToAddResponse(User savedUser);
}
