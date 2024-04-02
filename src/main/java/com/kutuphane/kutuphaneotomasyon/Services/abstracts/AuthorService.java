package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Author.Request.CreateAuthorRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.Response.CreateAuthorResponse;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.Request.UpdateAuthorRequest;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;

import java.util.List;

public interface AuthorService {
    CreateAuthorResponse add(CreateAuthorRequest dto);
    void update(UpdateAuthorRequest dto);
    void delete(int id);
    List<Author> getAll();

    Author getById(int id);


}
