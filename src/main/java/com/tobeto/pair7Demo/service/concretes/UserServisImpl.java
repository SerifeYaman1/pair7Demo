package com.tobeto.pair7Demo.service.concretes;

import com.tobeto.pair7Demo.core.utils.exceptions.types.BusinessException;
import com.tobeto.pair7Demo.entities.Category;
import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.repositories.UserRepository;
import com.tobeto.pair7Demo.service.abstacts.UserService;
import com.tobeto.pair7Demo.service.dto.requests.UserAddRequest;
import com.tobeto.pair7Demo.service.dto.responses.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.UserListingResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServisImpl implements UserService {

    private UserRepository userRepository;

    public UserServisImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public AddUserResponse add(UserAddRequest request) {

        userWithSameNameShouldNotExist(request.getFirstName());

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

    private void userWithSameNameShouldNotExist(String userName)
    {
        Optional<User> userWithSameName = userRepository.findByFirstNameIgnoreCase(userName);

        if(userWithSameName.isPresent())
            throw new BusinessException("Aynı isimde kullanıcı var. Lütfen kullanıcı adını değiştiriniz.");
    }
}
