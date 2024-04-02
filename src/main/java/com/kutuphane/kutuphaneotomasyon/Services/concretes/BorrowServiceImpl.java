package com.kutuphane.kutuphaneotomasyon.Services.concretes;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request.CreateBorrowRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request.UpdateBorrowRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Response.CreateBorrowResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Repository.BorrowRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreateBorrowResponse add(CreateBorrowRequest dto) {
        Borrow borrow = modelMapperService.forRequest().map(dto,Borrow.class);
        Borrow savedBorrow = borrowRepository.save(borrow);
        return new CreateBorrowResponse(savedBorrow.getId(),savedBorrow.getUser().getId(),savedBorrow.getBook().getId());
    }

    @Override
    public void update(UpdateBorrowRequest dto) {
        Borrow borrow = modelMapperService.forRequest().map(dto,Borrow.class);
        borrowRepository.saveAndFlush(borrow);

    }

    @Override
    public void delete(int id) {
    borrowRepository.deleteById(id);
    }

    @Override
    public List<Borrow> getAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow getById(int id) {
        return borrowRepository.findById(id).orElseThrow();
    }
}
