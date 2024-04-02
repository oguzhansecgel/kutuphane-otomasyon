package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.types.BusinessException;
import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Request.CreateUserRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Request.UpdateUserRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.User.Response.CreateUserResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Repository.UserRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreateUserResponse add(CreateUserRequest dto) {
        findByIdentityNoIgnoreCase(dto.getIdentityNo());
        User user = modelMapperService.forRequest().map(dto,User.class);
        User userSaved = userRepository.save(user);
        return new CreateUserResponse(userSaved.getId(), userSaved.getIdentityNo());
    }

    @Override
    public void update(UpdateUserRequest dto) {
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
    public void findByIdentityNoIgnoreCase(String identityNo)
    {
        Optional<User> hasUserIdentityNo =  userRepository.findByIdentityNoIgnoreCase(identityNo);
        if(hasUserIdentityNo.isPresent())
        {
            throw new BusinessException("Bu kimlik numarasına kayıtlı kullanıcı bulunmakta");
        }
    }
}
