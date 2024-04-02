package com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBorrowResponse {
    private int id;
    private int bookID;
    private int userID;
}
