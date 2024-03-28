package com.kutuphane.kutuphaneotomasyon.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String bookName;

    @OneToOne(mappedBy = "book")
    private ISBN isbn;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Borrow> borrows;

    @ManyToOne
    @JoinColumn(name = "authors_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genres_id")
    private Genres genres;

}
