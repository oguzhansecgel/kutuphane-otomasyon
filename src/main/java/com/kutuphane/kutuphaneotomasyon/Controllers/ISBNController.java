package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;
import com.kutuphane.kutuphaneotomasyon.Repository.ISBNRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ISBN")
@RequiredArgsConstructor
public class ISBNController {
    private final ISBNRepository isbnRepository;
    @GetMapping
    public List<ISBN> getAll()
    {
        return isbnRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<ISBN> getById(int id)
    {
        Optional<ISBN> genresOptional = isbnRepository.findById(id);
        return genresOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<ISBN> createISBN(@RequestBody ISBN isbn)
    {
        return ResponseEntity.ok(isbnRepository.save(isbn));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteISBN(@RequestParam int id)
    {
        isbnRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<ISBN> updateGenres(ISBN isbn)
    {
        Optional<ISBN> hasISBN = isbnRepository.findById(isbn.getId());
        if(hasISBN.isPresent())
        {
            isbnRepository.saveAndFlush(isbn);
            return new ResponseEntity<ISBN>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
