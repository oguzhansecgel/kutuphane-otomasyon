package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.CreateBookDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Book.UpdateBookDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Repository.BookRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(CreateBookDto dto) {
        Book book = this.modelMapperService.forRequest().map(dto,Book.class);
        bookRepository.save(book);
    }

    @Override
    public void update(UpdateBookDto dto) {
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
