package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Author.Request.CreateAuthorRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.Response.CreateAuthorResponse;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.Request.UpdateAuthorRequest;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<CreateAuthorResponse> createAuthor(@RequestBody @Valid CreateAuthorRequest dto)
    {
        CreateAuthorResponse response = authorService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("delete")
    public void deleteAuthor(@PathVariable int id)
    {
       this.authorService.delete(id);
    }
    @PutMapping("update")
    public void updateAuthor(@RequestBody @Valid UpdateAuthorRequest dto)
    {
         this.authorService.update(dto);

    }
}
