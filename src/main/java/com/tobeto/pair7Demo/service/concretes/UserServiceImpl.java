package com.tobeto.pair7Demo.service.concretes;

import com.tobeto.pair7Demo.core.utils.exceptions.types.BusinessException;
import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.repositories.UserRepository;
import com.tobeto.pair7Demo.service.abstacts.UserService;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.DeleteUserRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.UpdateUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.user.AddUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetAllUserResponse;
import com.tobeto.pair7Demo.service.dto.responses.user.GetByIdUserResponse;
import com.tobeto.pair7Demo.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override

        public AddUserResponse add(AddUserRequest request) {
            userWithSameNameShouldNotExist(request.getFirstName());

            User user = UserMapper.INSTANCE.userFromAddRequest(request);
            User savedUser = userRepository.save(user);

            return UserMapper.INSTANCE.userToAddResponse(savedUser);
    }


    @Override
    public void update(UpdateUserRequest request) {
        Optional<User> userOptional = userRepository.findById(request.getId());
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            // Güncelleme isteğine göre kullanıcı bilgilerini güncelle
            userToUpdate.setFirstName(request.getFirstName());
            // Diğer alanları da güncelleme işlemi burada yapabilirsiniz
            userRepository.save(userToUpdate);
        } else {
            throw new RuntimeException("Kullanıcı bulunamadı.");
        }
    }

    @Override
    public void delete(DeleteUserRequest request) {

        User user = userRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("id bulunamadı"));
        userRepository.delete(user);
    }

    @Override
    public List<GetAllUserResponse> getAll() {

        List<User> users = userRepository.findAll();

        List<GetAllUserResponse> result = new ArrayList<>();

        for (User user :
                users) {
            GetAllUserResponse dto = new GetAllUserResponse(user.getId(), user.getFirstName(), user.getLastName());
            result.add(dto);

        }
        return result;
    }
    @Override
    public GetByIdUserResponse getById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            GetByIdUserResponse response = new GetByIdUserResponse();
            response.setId(user.getId());
            response.setFirstName(user.getFirstName());
            // Diğer özelliklerinizi de ekleme işlemini burada yapabilirsiniz.
            return response;
        } else {
            throw new RuntimeException("Kullanıcı id'si bulunamadı.");
        }
    }

    private void userWithSameNameShouldNotExist(String userName) {
        Optional<User> userWithSameName = userRepository.findByFirstNameIgnoreCase(userName);

        if (userWithSameName.isPresent())
            throw new BusinessException("Aynı isimde kullanıcı var. Lütfen kullanıcı adını değiştiriniz.");
    }
}
