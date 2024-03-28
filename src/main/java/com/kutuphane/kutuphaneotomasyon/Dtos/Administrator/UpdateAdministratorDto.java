package com.kutuphane.kutuphaneotomasyon.Dtos.Administrator;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateAdministratorDto {
    private int id;

    private String userName;

    private int password;

    private String firstName;

    private String lastName;
}
