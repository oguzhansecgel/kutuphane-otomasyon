package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.User.Request.CreateUserRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Request.UpdateUserRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Response.CreateUserResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest dto)
    {
        CreateUserResponse response =  userService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("delete")
    public void deleteUser(@RequestParam int id)
    {
        userService.delete(id);
    }
    @PutMapping("update")
    public void updateUser(@RequestBody @Valid UpdateUserRequest dto)
    {
        userService.update(dto);

    }
}
