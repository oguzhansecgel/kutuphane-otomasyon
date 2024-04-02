package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.User.Request.CreateUserRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Request.UpdateUserRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Response.CreateUserResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.User;

import java.util.List;

public interface UserService {
    CreateUserResponse add(CreateUserRequest dto);
    void update(UpdateUserRequest dto);
    void delete(int id);
    List<User> getAll();

    User getById(int id);
}
