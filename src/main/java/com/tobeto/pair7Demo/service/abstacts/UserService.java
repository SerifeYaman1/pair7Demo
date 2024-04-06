package com.tobeto.pair7Demo.service.abstacts;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.dto.requests.UserAddRequest;
import com.tobeto.pair7Demo.service.dto.responses.UserListingResponse;

import java.util.List;

public interface UserService {

   void add(UserAddRequest request);

   void update(User user);

   void delete(int id);

   List<UserListingResponse> getAll();

   User getById(int id);

}
