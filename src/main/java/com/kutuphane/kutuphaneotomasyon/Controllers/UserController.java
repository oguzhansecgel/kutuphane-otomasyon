package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.User.CreateUserDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.UpdateUserDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Repository.UserRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll()
    {
        return userService.getAll();
    }
    @GetMapping("getById")
    public User getById(int id)
    {
        return userService.getById(id);
    }
    @PostMapping("create")
    public void createUser(@RequestBody CreateUserDto dto)
    {
        userService.add(dto);
    }
    @DeleteMapping("delete")
    public void deleteUser(@RequestParam int id)
    {
        userService.delete(id);
    }
    @PutMapping("update")
    public void updateUser(UpdateUserDto dto)
    {
        userService.update(dto);

    }
}
