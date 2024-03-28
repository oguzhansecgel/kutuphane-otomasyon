package com.kutuphane.kutuphaneotomasyon.Dtos.Author;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateAuthorDto {
    private int id;

    private String firstName;

    private  String lastName;
}
