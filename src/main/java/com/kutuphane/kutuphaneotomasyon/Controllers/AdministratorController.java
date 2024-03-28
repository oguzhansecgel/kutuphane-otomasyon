package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.mappers.ModelMapperService;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.CreateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.UpdateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Repository.AdministratorRepository;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("create")
    public void add(@RequestBody CreateAdministratorDto dto)
    {
        administratorService.add(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        administratorService.delete(id);

    }
    @PutMapping("update")
    public void update(@RequestBody UpdateAdministratorDto dto)
    {
        administratorService.update(dto);
    }
}
