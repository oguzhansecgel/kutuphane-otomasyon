package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request.CreateAdministratorRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Response.CreateAdministratorResponse;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request.UpdateAdministratorRequest;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;

import java.util.List;
public interface AdministratorService {
    CreateAdministratorResponse add(CreateAdministratorRequest dto);
    void update(UpdateAdministratorRequest dto);
    void delete(int id);
    List<Administrator> getAll();

    Administrator getById(int id);
}
