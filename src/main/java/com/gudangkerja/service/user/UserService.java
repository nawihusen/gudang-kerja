package com.gudangkerja.service.user;

import com.gudangkerja.model.user.UserData;
import com.gudangkerja.model.user.UserRegisterRequest;
import com.gudangkerja.model.user.UserUpdate;

public interface UserService {

    void register(UserRegisterRequest request);

    void updateData(UserUpdate request);

    void delete(Long id);

    UserData getUser(Long id);
}
