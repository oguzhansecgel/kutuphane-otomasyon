package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Request.CreateISBNRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Response.CreateISBNResponse;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.ISBNService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ISBN")
@RequiredArgsConstructor
public class ISBNController {
    private final ISBNService isbnService;
    @GetMapping
    public List<ISBN> getAll()
    {
        return isbnService.getAll();
    }
    @GetMapping("getById")
    public ISBN getById(int id)
    {
         return isbnService.getById(id);
    }
    @PostMapping("create")
    public ResponseEntity<CreateISBNResponse> createISBN(@RequestBody @Valid CreateISBNRequest dto)
    {
        CreateISBNResponse response = isbnService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("delete")
    public void deleteISBN(@RequestParam int id)
    {
        isbnService.delete(id);


    }
    @PutMapping("update")
    public void updateGenres(ISBN isbn)
    {
        isbnService.update(isbn);

    }
}
