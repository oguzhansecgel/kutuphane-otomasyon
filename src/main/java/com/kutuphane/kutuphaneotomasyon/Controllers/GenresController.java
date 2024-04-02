package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request.CreateGenresRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request.UpdateGenresRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Response.CreateGenresResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.GenresService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<CreateGenresResponse> createGenres(@RequestBody @Valid CreateGenresRequest dto)
    {
        CreateGenresResponse response = genresService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("delete")
    public void deleteGenres(@RequestParam int id)
    {
        genresService.delete(id);

    }
    @PutMapping("update")
    public void updateGenres(@RequestBody @Valid UpdateGenresRequest dto)
    {
        genresService.update(dto);

    }
}
