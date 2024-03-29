package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Book.CreateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.UpdateBookDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Repository.BookRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public void createBook(@RequestBody CreateBookDto dto)
    {
        bookService.add(dto);
    }
    @DeleteMapping("delete")
    public void deleteBook(@RequestParam int id)
    {
        bookService.delete(id);
    }
    @PutMapping("update")
    public void updateBook(@RequestBody UpdateBookDto dto)
    {
        bookService.update(dto);

    }



}
