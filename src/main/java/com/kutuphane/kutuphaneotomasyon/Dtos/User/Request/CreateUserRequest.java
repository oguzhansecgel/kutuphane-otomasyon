package com.kutuphane.kutuphaneotomasyon.Dtos.User.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "IdentityNo alanı boş geçilemez")
    @Size(min = 1,max = 50)
    private String identityNo;
    @NotBlank(message = "İsim alanı boş geçilemez")
    @Size(min = 1,max = 50)
    private String firstName;

    @NotBlank(message = "Soyisim alanı boş geçilemez")
    @Size(min = 1,max = 50)
    private String lastName;

    @NotBlank(message = "Mail alanı boş geçilemez")
    @Size(min = 1,max = 50)
    private String mail;
    @NotBlank(message = "Telefon alanı boş geçilemez")
    @Size(min = 1,max = 50)
    private String phoneNumber;
}
