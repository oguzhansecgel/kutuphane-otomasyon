package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.CreateUserDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.UpdateUserDto;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Repository.UserRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(CreateUserDto dto) {
        User user = modelMapperService.forRequest().map(dto,User.class);
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserDto dto) {
        User user = modelMapperService.forRequest().map(dto,User.class);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(int id) {
      userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow();
    }
}
