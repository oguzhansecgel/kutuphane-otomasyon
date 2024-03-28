package com.kutuphane.kutuphaneotomasyon.Dtos.User;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateUserDto {
    private int id;

    private String identityNo;

    private String firstName;

    private String lastName;
    private String mail;
    private String phoneNumber;
}
