package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Request.CreateISBNRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Response.CreateISBNResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;

import java.util.List;

public interface ISBNService {
    CreateISBNResponse add(CreateISBNRequest dto);
    void update(ISBN dto);
    void delete(int id);
    List<ISBN> getAll();

    ISBN getById(int id);
}
