package com.kutuphane.kutuphaneotomasyon.Dtos.Book;

import com.kutuphane.kutuphaneotomasyon.Entities.Author;
import com.kutuphane.kutuphaneotomasyon.Entities.Borrow;
import com.kutuphane.kutuphaneotomasyon.Entities.Genres;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
public class CreateBookDto {

    private String bookName;

    private int isbnId;

    private int authorID;

    private int genresID;
}
