package com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGenresResponse {
    private int id;
    private String name;
}
