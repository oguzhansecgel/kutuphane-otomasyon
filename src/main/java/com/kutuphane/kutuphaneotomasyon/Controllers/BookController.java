package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAll()
    {
        return bookRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<Book> getById(int id)
    {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<Book> createBook(@RequestBody Book book)
    {
        return ResponseEntity.ok(bookRepository.save(book));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteBook(@RequestParam int id)
    {
        bookRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<Book> updateBook(Book book)
    {
        Optional<Book> hasBook = bookRepository.findById(book.getId());
        if(hasBook.isPresent())
        {
            bookRepository.saveAndFlush(book);
            return new ResponseEntity<Book>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
