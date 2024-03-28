package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.CreateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.CreateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.UpdateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;

import java.util.List;

public interface AuthorService {
    void add(CreateAuthorDto dto);
    void update(UpdateAuthorDto dto);
    void delete(int id);
    List<Author> getAll();

    Author getById(int id);
}
