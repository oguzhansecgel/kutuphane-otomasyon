package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.CreateGenresDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.UpdateGenresDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import com.kutuphane.kutuphaneotomasyon.Repository.GenresRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenresController {

    private final GenresService genresService;
    @GetMapping
    public List<Genres> getAll()
    {
        return genresService.getAll();
    }
    @GetMapping("getById")
    public Genres getById(int id)
    {
        return genresService.getById(id);
    }
    @PostMapping("create")
    public void createGenres(@RequestBody CreateGenresDto dto)
    {
        genresService.add(dto);
    }
    @DeleteMapping("delete")
    public void deleteGenres(@RequestParam int id)
    {
        genresService.delete(id);

    }
    @PutMapping("update")
    public void updateGenres(UpdateGenresDto dto)
    {
        genresService.update(dto);

    }
}
