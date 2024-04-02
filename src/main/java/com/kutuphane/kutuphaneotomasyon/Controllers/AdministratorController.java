package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request.CreateAdministratorRequest;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Response.CreateAdministratorResponse;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request.UpdateAdministratorRequest;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AdministratorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/administrator")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;
    @GetMapping
    public List<Administrator> getAll()
    {
        return administratorService.getAll();
    }
   @GetMapping("getById")
    public Administrator getById(int id)
    {
        return administratorService.getById(id);
    }
    @PostMapping
    public ResponseEntity<CreateAdministratorResponse> add(@RequestBody @Valid CreateAdministratorRequest dto)
    {
        CreateAdministratorResponse response = administratorService.add(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        administratorService.delete(id);

    }
    @PutMapping("update")
    public void update(@RequestBody @Valid UpdateAdministratorRequest dto)
    {
        administratorService.update(dto);
    }
}
