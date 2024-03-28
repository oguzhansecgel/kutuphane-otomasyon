package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.CreateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.UpdateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Repository.AdministratorRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(CreateAdministratorDto dto) {
        Administrator administrator = this.modelMapperService.forRequest().map(dto,Administrator.class);

        administratorRepository.save(administrator);
    }

    @Override
    public void update(UpdateAdministratorDto dto) {
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
}
