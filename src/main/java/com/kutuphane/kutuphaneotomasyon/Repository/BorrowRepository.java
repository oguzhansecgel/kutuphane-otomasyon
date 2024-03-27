package com.kutuphane.kutuphaneotomasyon.Repository;

import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
}
