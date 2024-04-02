package com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdministratorRequest {
    private int id;
    @NotBlank
    @Size(min = 1,max = 50)
    private String userName;

    private int password;
    @NotBlank
    @Size(min = 1,max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 1,max = 50)
    private String lastName;
}
