package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Author.CreateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.UpdateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Repository.AuthorRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AuthorService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAll()
    {
        return authorService.getAll();
    }
    @GetMapping("getById")
    public Author getById(int id)
    {
        return authorService.getById(id);
    }
    @PostMapping("create")
    public void createAuthor(@RequestBody CreateAuthorDto dto)
    {
        this.authorService.add(dto);
    }
    @DeleteMapping("delete")
    public void deleteAuthor(@PathVariable int id)
    {
       this.authorService.delete(id);
    }
    @PutMapping("update")
    public void updateAuthor(@RequestBody UpdateAuthorDto dto)
    {
         this.authorService.update(dto);

    }
}
