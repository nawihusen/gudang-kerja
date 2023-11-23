package com.gudangkerja.service.user;

import com.gudangkerja.entities.User;
import com.gudangkerja.model.user.UserData;
import com.gudangkerja.model.user.UserRegisterRequest;
import com.gudangkerja.model.user.UserUpdate;
import com.gudangkerja.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateData(UserUpdate request) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserData getUser(Long id) {
        return null;
    }
}
