package com.kutuphane.kutuphaneotomasyon.Repository;

import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISBNRepository extends JpaRepository<ISBN,Integer> {
}
