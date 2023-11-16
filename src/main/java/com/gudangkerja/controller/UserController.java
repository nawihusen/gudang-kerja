package com.gudangkerja.controller;

import com.gudangkerja.model.Response;
import com.gudangkerja.model.user.UserData;
import com.gudangkerja.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
     private UserService userService;

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserData> getUserData(@PathVariable Long id){
        var userData = userService.getUser(id);
        return Response.<UserData>builder().data(userData).build();
    }
}
