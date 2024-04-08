package com.tobeto.pair7Demo.service.mapper;

import com.tobeto.pair7Demo.entities.Contact;
import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.UpdateUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.user.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetAllUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetByIdUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userFromAddRequest(AddUserRequest request);

    @Mapping(target = "email", source = "contacts.email", qualifiedByName = "mapContactsToEmail")
    AddUserResponse userToAddResponse(User savedUser);

    @Named("mapContactsToEmail")
    default String mapContactsToEmail(List<Contact> contacts) {
        if (contacts != null && !contacts.isEmpty()) {
            return contacts.get(0).getEmail();
        }
        return null;
    }
    @Mapping(target = "email", source = "contacts.email", qualifiedByName = "mapContactsToEmail")
    GetAllUserResponse userToGetAllResponse(User user);

    GetByIdUserResponse userToGetById(User user);
    User userFromUpdateRequest(UpdateUserRequest request);
}
