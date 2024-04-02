package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request.CreateBookRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request.UpdateBookRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Response.CreateBookResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;

import java.util.List;

public interface BookService {
    CreateBookResponse add(CreateBookRequest dto);
    void update(UpdateBookRequest dto);
    void delete(int id);
    List<Book> getAll();

    Book getById(int id);



}
