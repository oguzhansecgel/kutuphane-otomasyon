package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.CreateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Author.UpdateAuthorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Repository.AuthorRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(CreateAuthorDto dto) {
        Author author = this.modelMapperService.forRequest().map(dto,Author.class);
        authorRepository.save(author);
    }

    @Override
    public void update(UpdateAuthorDto dto) {
        Author author = this.modelMapperService.forRequest().map(dto,Author.class);
        Optional<Author> authorCheck = authorRepository.findById(dto.getId());
        if(authorCheck.isEmpty())
        {
            throw new RuntimeException("ID bulunamadi");
        }
        authorRepository.saveAndFlush(author);
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {
        return authorRepository.findById(id).orElseThrow();
    }
}
