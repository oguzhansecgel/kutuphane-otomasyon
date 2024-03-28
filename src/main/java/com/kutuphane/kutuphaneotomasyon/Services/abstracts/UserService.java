package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.CreateBorrowDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.CreateUserDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.UpdateUserDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Entities.User;

import java.util.List;

public interface UserService {
    void add(CreateUserDto dto);
    void update(UpdateUserDto dto);
    void delete(int id);
    List<User> getAll();

    User getById(int id);
}
