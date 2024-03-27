package com.kutuphane.kutuphaneotomasyon.Repository;

import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
