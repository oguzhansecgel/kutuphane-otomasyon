package com.kutuphane.kutuphaneotomasyon.Dtos.Book.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookResponse {
    private int id;
    private String bookName;
}
