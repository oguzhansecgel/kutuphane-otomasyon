package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request.CreateBookRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request.UpdateBookRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.Response.CreateBookResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Repository.BookRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public CreateBookResponse add(CreateBookRequest dto) {
        Book book = this.modelMapperService.forRequest().map(dto,Book.class);
        Book savedBook = bookRepository.save(book);
        return new CreateBookResponse(savedBook.getId(), savedBook.getBookName());
    }

    @Override
    public void update(UpdateBookRequest dto) {
        Book book = this.modelMapperService.forRequest().map(dto,Book.class);
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).orElseThrow();
    }


}
