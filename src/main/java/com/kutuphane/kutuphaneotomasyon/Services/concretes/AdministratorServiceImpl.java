package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.types.BusinessException;
import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request.CreateAdministratorRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Response.CreateAdministratorResponse;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request.UpdateAdministratorRequest;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Repository.AdministratorRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public CreateAdministratorResponse add(CreateAdministratorRequest dto) {
        findByUserNameIgnoreCase(dto.getUserName());
        Administrator administrator = this.modelMapperService.forRequest().map(dto,Administrator.class);

        Administrator savedAdmin = administratorRepository.save(administrator);
        return new CreateAdministratorResponse(savedAdmin.getId(), savedAdmin.getUserName());
    }

    @Override
    public void update(UpdateAdministratorRequest dto) {
        Administrator administrator = this.modelMapperService.forRequest().map(dto,Administrator.class);
        administratorRepository.save(administrator);
    }

    @Override
    public void delete(int id) {administratorRepository.deleteById(id);
    }

    @Override
    public List<Administrator> getAll() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator getById(int id) {
        return administratorRepository.findById(id).orElseThrow();
    }
    public void findByUserNameIgnoreCase(String userName)
    {
        Optional<Administrator> administrator =  administratorRepository.findByUserNameIgnoreCase(userName);
        if(administrator.isPresent())
        {
            throw new BusinessException("Aynı kullanıcı adı bulunmakta");
        }
    }
}
