package com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.Response;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateISBNResponse {
    private int id;

    private String number;
}
