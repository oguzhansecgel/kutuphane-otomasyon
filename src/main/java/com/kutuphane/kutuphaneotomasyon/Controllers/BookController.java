package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request.CreateBookRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request.UpdateBookRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Response.CreateBookResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAll()
    {
        return bookService.getAll();
    }
    @GetMapping("getById")
    public Book getById(int id)
    {
        return bookService.getById(id);
    }
    @PostMapping("create")
    public ResponseEntity<CreateBookResponse> createBook(@RequestBody @Valid CreateBookRequest dto)
    {
        CreateBookResponse response = bookService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("delete")
    public void deleteBook(@RequestParam int id)
    {
        bookService.delete(id);
    }
    @PutMapping("update")
    public void updateBook(@RequestBody @Valid UpdateBookRequest dto)
    {
        bookService.update(dto);

    }



}
