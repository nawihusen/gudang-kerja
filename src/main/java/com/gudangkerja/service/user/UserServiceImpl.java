package com.gudangkerja.service.user;

import com.gudangkerja.entities.User;
import com.gudangkerja.model.user.UserData;
import com.gudangkerja.model.user.UserRegisterRequest;
import com.gudangkerja.model.user.UserUpdate;
import com.gudangkerja.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(UserRegisterRequest request) {
        var user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }

    @Override
    public void updateData(UserUpdate request, Long id) {
        var user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        if (Objects.nonNull(request.getName())){
            user.setName(request.getName());
        }

        if (Objects.nonNull(request.getPhone())){
            user.setPhone(request.getPhone());
        }

        if (Objects.nonNull(request.getWa())){
            user.setWa(request.getWa());
        }

        if (Objects.nonNull(request.getPassword())){
            user.setPassword(request.getPassword());
        }

        if (Objects.nonNull(request.getAddress())){
            user.setAddress(request.getAddress());
        }
    }

    @Override
    public void delete(Long id) {
        var user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        userRepository.delete(user);
    }

    @Override
    public UserData getUser(Long id) {
        return null;
    }
}
