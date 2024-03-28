package com.kutuphane.kutuphaneotomasyon.Dtos.Borrow;

import com.kutuphane.kutuphaneotomasyon.Entities.Book;
import com.kutuphane.kutuphaneotomasyon.Entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CreateBorrowDto {

    private String borrowDate;

    private String dueDate;

    private String deliveryDate;

    private int borrowClaim;

    private int bookID;

    private int userID;
}
