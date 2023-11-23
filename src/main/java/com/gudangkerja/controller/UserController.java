package com.gudangkerja.controller;

import com.gudangkerja.model.Response;
import com.gudangkerja.model.user.UserData;
import com.gudangkerja.model.user.UserRegisterRequest;
import com.gudangkerja.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
     private UserService userService;

    @GetMapping(path = "/user/{id}")
    public Response<UserData> getUserData(@PathVariable Long id){
        var userData = userService.getUser(id);
        return Response.<UserData>builder().data(userData).build();
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> register(@RequestBody UserRegisterRequest request){
        userService.register(request);
        return Response.<String>builder().data("Success").build();
    }
}
