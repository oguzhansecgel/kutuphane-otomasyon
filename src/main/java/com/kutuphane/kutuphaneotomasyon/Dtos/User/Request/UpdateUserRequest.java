package com.kutuphane.kutuphaneotomasyon.Dtos.User.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private int id;
    @NotBlank
    @Size(min = 1,max = 50)
    private String identityNo;
    @NotBlank
    @Size(min = 1,max = 50)

    private String firstName;
    @NotBlank
    @Size(min = 1,max = 50)

    private String lastName;
    @NotBlank
    @Size(min = 1,max = 50)
    private String mail;
    @NotBlank
    @Size(min = 1,max = 50)
    private String phoneNumber;
}
