package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import com.kutuphane.kutuphaneotomasyon.Repository.GenresRepository;
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

    private final GenresRepository genresRepository;
    @GetMapping
    public List<Genres> getAll()
    {
        return genresRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<Genres> getById(int id)
    {
        Optional<Genres> genresOptional = genresRepository.findById(id);
        return genresOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<Genres> createGenres(@RequestBody Genres genres)
    {
        return ResponseEntity.ok(genresRepository.save(genres));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteGenres(@RequestParam int id)
    {
        genresRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<Genres> updateGenres(Genres genres)
    {
        Optional<Genres> hasGenres = genresRepository.findById(genres.getId());
        if(hasGenres.isPresent())
        {
            genresRepository.saveAndFlush(genres);
            return new ResponseEntity<Genres>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
