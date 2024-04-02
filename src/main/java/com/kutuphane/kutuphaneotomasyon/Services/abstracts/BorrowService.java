package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request.CreateBorrowRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request.UpdateBorrowRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Response.CreateBorrowResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;

import java.util.List;

public interface BorrowService {
    CreateBorrowResponse add(CreateBorrowRequest dto);
    void update(UpdateBorrowRequest dto);
    void delete(int id);
    List<Borrow> getAll();

    Borrow getById(int id);
}
