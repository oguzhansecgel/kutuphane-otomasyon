package com.kutuphane.kutuphaneotomasyon.Services.abstracts;

import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request.CreateGenresRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request.UpdateGenresRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Response.CreateGenresResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;

import java.util.List;

public interface GenresService {
    CreateGenresResponse add(CreateGenresRequest dto);
    void update(UpdateGenresRequest dto);
    void delete(int id);
    List<Genres> getAll();

    Genres getById(int id);
}
