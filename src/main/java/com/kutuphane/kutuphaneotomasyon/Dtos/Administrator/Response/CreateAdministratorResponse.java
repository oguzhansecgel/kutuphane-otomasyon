package com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdministratorResponse {
    private int id;
    private String userName;

}
