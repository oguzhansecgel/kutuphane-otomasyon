package com.kutuphane.kutuphaneotomasyon.Dtos.Author.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorRequest {
    @NotBlank
    @Size(min = 2,max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 1,max = 50)
    private  String lastName;

}
