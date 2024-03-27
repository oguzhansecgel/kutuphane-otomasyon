package com.kutuphane.kutuphaneotomasyon.Repository;

import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
