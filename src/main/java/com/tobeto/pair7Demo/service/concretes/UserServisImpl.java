package com.tobeto.pair7Demo.service.concretes;

import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.repositories.UserRepository;
import com.tobeto.pair7Demo.service.abstacts.UserService;
import com.tobeto.pair7Demo.service.dto.requests.UserAddRequest;
import com.tobeto.pair7Demo.service.dto.responses.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.UserListingResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServisImpl implements UserService {

    private UserRepository userRepository;

    public UserServisImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public AddUserResponse add(UserAddRequest request) {

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser = userRepository.save(user);
        AddUserResponse response = new AddUserResponse(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName());

        return response;
    }

    @Override
    public void update(User user) {

        userRepository.save(user);
    }

    @Override
    public void delete(int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("id bulunamadı"));
        userRepository.delete(user);
    }

    @Override
    public List<UserListingResponse> getAll() {

        List<User> users = userRepository.findAll();

        List<UserListingResponse> result = new ArrayList<>();

        for(User user:
                users){
            UserListingResponse dto = new UserListingResponse(user.getId(),user.getFirstName(),user.getLastName());
            result.add(dto);

        }
        return result;
    }

    @Override
    public User getById(int id) {

     return   userRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Kullanıcı id'si bulunamadı."));

    }

    private void method(String name){
        //TODO repositorye ekleme
//        if(name.getFirst_name().length() <3)
//            throw new RuntimeException("Kullanıcı adı en az 3 haneli olmalıdır");
    }
}
