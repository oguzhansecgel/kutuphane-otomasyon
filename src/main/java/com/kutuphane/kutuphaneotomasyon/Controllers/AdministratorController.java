package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import com.kutuphane.kutuphaneotomasyon.Repository.AdministratorRepository;
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
    private final AdministratorRepository administratorRepository;
    @GetMapping
    public List<Administrator> getAll()
    {
        return administratorRepository.findAll();
    }
    @GetMapping("getById")
    public ResponseEntity<Administrator> getById(int id)
    {
        Optional<Administrator> administratorOptional = administratorRepository.findById(id);
        return administratorOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("create")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator)
    {
        return ResponseEntity.ok(administratorRepository.save(administrator));
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteAdministrator(@RequestParam int id)
    {
        administratorRepository.deleteById(id);

        return ResponseEntity.ok("Silme Başarılı"+id);
    }
    @PutMapping("update")
    public ResponseEntity<Administrator> updateAdministrator(Administrator administrator)
    {
        Optional<Administrator> hasAdministrator = administratorRepository.findById(administrator.getId());
        if(hasAdministrator.isPresent())
        {
            administratorRepository.saveAndFlush(administrator);
            return new ResponseEntity<Administrator>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
