package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.CreateBorrowDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Repository.BorrowRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;
  @GetMapping
    public List<Borrow> getAll()
    {
        return borrowService.getAll();
    }
    @GetMapping("getById")
    public Borrow getById(int id)
    {
        return borrowService.getById(id);
    }
    @PostMapping("create")
    public void createBorrow(@RequestBody CreateBorrowDto dto)
    {
        borrowService.add(dto);
    }
 @DeleteMapping("delete")
    public void deleteBorrow(@RequestParam int id)
    {
        borrowService.delete(id);
    }
   @PutMapping("update")
    public void updateBook(Borrow borrow)
    {
       borrowService.update(borrow);

    }
}
