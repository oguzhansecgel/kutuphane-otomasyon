package com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdministratorRequest {
    @NotBlank
    @Size(min = 3,max = 50, message = "Minimum 3 maximum 50 karakterlik veri girişi yapınız")
    private String userName;
    private int password;
    @NotBlank
    @Size(min = 1,max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 1,max = 50)
    private String lastName;
}