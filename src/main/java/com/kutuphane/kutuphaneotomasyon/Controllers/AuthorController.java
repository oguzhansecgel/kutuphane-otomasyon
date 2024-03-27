package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAll()
    {
        return authorRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<Author> getById(int id)
    {
        Optional<Author> authorOptional = authorRepository.findById(id);
        return authorOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author)
    {
        return ResponseEntity.ok(authorRepository.save(author));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam int id)
    {
        authorRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<Author> updateAuthor(Author author)
    {
        Optional<Author> hasAuthor = authorRepository.findById(author.getId());
        if(hasAuthor.isPresent())
        {
            authorRepository.saveAndFlush(author);
            return new ResponseEntity<Author>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
