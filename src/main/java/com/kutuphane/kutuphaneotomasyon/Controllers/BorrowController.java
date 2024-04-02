package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request.CreateBorrowRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request.UpdateBorrowRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Response.CreateBorrowResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<CreateBorrowResponse> createBorrow(@RequestBody @Valid CreateBorrowRequest dto)
    {
        CreateBorrowResponse response =  borrowService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
 @DeleteMapping("delete")
    public void deleteBorrow(@RequestParam int id)
    {
        borrowService.delete(id);
    }
   @PutMapping("update")
    public void updateBook(@RequestBody @Valid UpdateBorrowRequest dto)
    {
       borrowService.update(dto);

    }
}
