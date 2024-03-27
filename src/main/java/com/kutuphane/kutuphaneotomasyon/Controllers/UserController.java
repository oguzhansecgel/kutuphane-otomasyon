package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Repository.UserRepository;
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
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<User> getById(int id)
    {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userRepository.save(user));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestParam int id)
    {
        userRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<User> updateUser(User user)
    {
        Optional<User> hasUser = userRepository.findById(user.getId());
        if(hasUser.isPresent())
        {
            userRepository.saveAndFlush(user);
            return new ResponseEntity<User>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
