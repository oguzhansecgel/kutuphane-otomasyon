package com.kutuphane.kutuphaneotomasyon.Dtos.ISBN;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateISBNDto {

    private String number;

    private String publicationYear;

    private String publisher;
}
