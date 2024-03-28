package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.CreateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.UpdateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AdministratorService {
    void add(CreateAdministratorDto dto);
    void update(UpdateAdministratorDto dto);
    void delete(int id);
    List<Administrator> getAll();

    Administrator getById(int id);
}
