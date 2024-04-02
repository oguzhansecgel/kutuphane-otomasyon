package com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateISBNRequest {
    @NotBlank
    @Size(min = 1,max = 50)
    private String number;
    @NotBlank
    @Size(min = 1,max = 50)

    private String publicationYear;
    @NotBlank
    @Size(min = 1,max = 50)

    private String publisher;
}
