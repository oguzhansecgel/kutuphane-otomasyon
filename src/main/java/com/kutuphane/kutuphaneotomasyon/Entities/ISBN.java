package com.kutuphane.kutuphaneotomasyon.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ısbn")
public class ISBN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "publication_year")
    private String publicationYear;

    @Column(name = "publisher")
    private String publisher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
}
