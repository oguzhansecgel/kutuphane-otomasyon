package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Book.CreateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.UpdateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.CreateISBNDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;

import java.util.List;

public interface ISBNService {
    void add(CreateISBNDto dto);
    void update(ISBN dto);
    void delete(int id);
    List<ISBN> getAll();

    ISBN getById(int id);
}
