package com.tobeto.pair7Demo.service.abstacts;

import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.UpdateUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.user.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetAllUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetByIdUserResponse;

import java.util.List;

public interface UserService {

   AddUserResponse add(AddUserRequest request);

   void update(UpdateUserRequest request);

   void delete(int id);

   List<GetAllUserResponse> getAll();

   GetByIdUserResponse getById(int id);

}
