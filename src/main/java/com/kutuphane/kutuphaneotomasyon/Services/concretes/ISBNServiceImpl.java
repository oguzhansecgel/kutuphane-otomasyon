package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Request.CreateISBNRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Response.CreateISBNResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;
import com.kutuphane.kutuphaneotomasyon.Repository.ISBNRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.ISBNService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ISBNServiceImpl implements ISBNService {

    private final ISBNRepository isbnRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public CreateISBNResponse add(CreateISBNRequest dto) {
        ISBN isbn = modelMapperService.forRequest().map(dto,ISBN.class);
        ISBN savedISBN =  isbnRepository.save(isbn);
        return new CreateISBNResponse(savedISBN.getId(),savedISBN.getNumber());
    }

    @Override
    public void update(ISBN dto) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ISBN> getAll() {
        return null;
    }

    @Override
    public ISBN getById(int id) {
        return null;
    }
}
