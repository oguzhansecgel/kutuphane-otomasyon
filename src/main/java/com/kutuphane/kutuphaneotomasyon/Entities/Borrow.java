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
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "borrow_date")
    private String borrowDate;
    @Column(name = "due_date")
    private String dueDate;
    @Column(name = "delivery_date")
    private String deliveryDate;
    @Column(name = "borrow_claim")
    private int borrowClaim;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
