package com.kutuphane.kutuphaneotomasyon.Dtos.Author.Response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorResponse {
    private int id;
    private String firstName;
    private  String lastName;
}
