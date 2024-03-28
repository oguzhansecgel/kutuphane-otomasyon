package com.kutuphane.kutuphaneotomasyon.Dtos.Genres;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateGenresDto {
    private int id;

    private String name;
}
