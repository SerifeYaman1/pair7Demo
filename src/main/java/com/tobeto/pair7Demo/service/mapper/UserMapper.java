package com.tobeto.pair7Demo.service.mapper;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.dto.requests.UserAddRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userFromAddRequest(UserAddRequest request);
}
