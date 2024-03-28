package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Book.CreateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.UpdateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.CreateBorrowDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;

import java.util.List;

public interface BorrowService {
    void add(CreateBorrowDto dto);
    void update(Borrow dto);
    void delete(int id);
    List<Borrow> getAll();

    Borrow getById(int id);
}
