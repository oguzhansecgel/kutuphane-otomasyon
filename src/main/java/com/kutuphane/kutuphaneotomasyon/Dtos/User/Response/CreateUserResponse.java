package com.kutuphane.kutuphaneotomasyon.Dtos.User.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private int id;
    private String identityNo;
}
