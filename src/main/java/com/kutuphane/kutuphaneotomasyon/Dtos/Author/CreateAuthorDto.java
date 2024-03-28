package com.kutuphane.kutuphaneotomasyon.Dtos.Author;

import jakarta.persistence.Column;

public class CreateAuthorDto {
    private String firstName;
    @Column(name = "last_name")
    private  String lastName;

}
