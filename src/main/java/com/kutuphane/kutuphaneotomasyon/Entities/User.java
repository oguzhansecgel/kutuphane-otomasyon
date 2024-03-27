package com.kutuphane.kutuphaneotomasyon.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   @Column(name = "identityno")
    private String identityNo;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String lastName;

    @Column(name = "phonenumber")
    private String phoneNumber;

   @OneToMany(mappedBy = "user")
    private List<Borrow> borrows;
}
