package com.kutuphane.kutuphaneotomasyon.Repository;

import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres,Integer> {
}
