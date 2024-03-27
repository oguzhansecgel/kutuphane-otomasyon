package com.kutuphane.kutuphaneotomasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private int password;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String lastName;

}
