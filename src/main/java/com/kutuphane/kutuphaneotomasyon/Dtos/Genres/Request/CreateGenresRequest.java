package com.kutuphane.kutuphaneotomasyon.Dtos.Genres.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGenresRequest {
    @NotBlank
    @Size(min = 1,max = 50)
    private String name;
}
