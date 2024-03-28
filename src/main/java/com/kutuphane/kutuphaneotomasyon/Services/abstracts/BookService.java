package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Author.CreateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.UpdateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.CreateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.UpdateBookDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void add(CreateBookDto dto);
    void update(UpdateBookDto dto);
    void delete(int id);
    List<Book> getAll();

    Book getById(int id);



}
