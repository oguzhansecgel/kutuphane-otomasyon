package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request.CreateGenresRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request.UpdateGenresRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Response.CreateGenresResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import com.kutuphane.kutuphaneotomasyon.Repository.GenresRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {
    private final GenresRepository genresRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreateGenresResponse add(CreateGenresRequest dto) {
        Genres genres = modelMapperService.forRequest().map(dto,Genres.class);
        Genres savedGenres = genresRepository.save(genres);
        return new CreateGenresResponse(savedGenres.getId(), savedGenres.getName());
    }

    @Override
    public void update(UpdateGenresRequest dto) {
        Genres genres = modelMapperService.forRequest().map(dto,Genres.class);
        genresRepository.saveAndFlush(genres);
    }

    @Override
    public void delete(int id) {
        genresRepository.deleteById(id);
    }

    @Override
    public List<Genres> getAll() {
        return genresRepository.findAll();
    }

    @Override
    public Genres getById(int id) {
        return genresRepository.findById(id).orElseThrow();
    }
}
