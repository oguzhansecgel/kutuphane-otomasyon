package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.CreateBorrowDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.CreateGenresDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.UpdateGenresDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;

import java.util.List;

public interface GenresService {
    void add(CreateGenresDto dto);
    void update(UpdateGenresDto dto);
    void delete(int id);
    List<Genres> getAll();

    Genres getById(int id);
}
