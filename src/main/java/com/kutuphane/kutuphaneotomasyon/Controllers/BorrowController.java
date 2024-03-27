package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Repository.BorrowRepository;
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
    private final BorrowRepository borrowRepository;
    @GetMapping
    public List<Borrow> getAll()
    {
        return borrowRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<Borrow> getById(int id)
    {
        Optional<Borrow> borrowOptional = borrowRepository.findById(id);
        return borrowOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<Borrow> createBorrow(@RequestBody Borrow borrow)
    {
        return ResponseEntity.ok(borrowRepository.save(borrow));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteBorrow(@RequestParam int id)
    {
        borrowRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<Borrow> updateBook(Borrow borrow)
    {
        Optional<Borrow> hasBorrow = borrowRepository.findById(borrow.getId());
        if(hasBorrow.isPresent())
        {
            borrowRepository.saveAndFlush(borrow);
            return new ResponseEntity<Borrow>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
