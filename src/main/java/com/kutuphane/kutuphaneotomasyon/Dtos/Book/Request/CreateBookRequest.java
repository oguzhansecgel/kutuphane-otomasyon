package com.kutuphane.kutuphaneotomasyon.Dtos.Book.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    @NotBlank
    @Size(min = 1,max = 50)
    private String bookName;
    @NotBlank
    @Size(min = 1,max = 50)
    private int isbnId;
    @NotBlank
    @Size(min = 1,max = 50)
    private int authorID;
    @NotBlank
    @Size(min = 1,max = 50)
    private int genresID;
}
