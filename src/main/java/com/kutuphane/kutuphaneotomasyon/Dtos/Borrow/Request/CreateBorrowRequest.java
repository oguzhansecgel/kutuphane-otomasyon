package com.kutuphane.kutuphaneotomasyon.Dtos.Borrow.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBorrowRequest {
    @NotBlank
    @Size(min = 1,max = 50)

    private String borrowDate;
    @NotBlank
    @Size(min = 1,max = 50)

    private String dueDate;
    @NotBlank
    @Size(min = 1,max = 50)

    private String deliveryDate;
    @NotBlank
    @Size(min = 1,max = 50)

    private int borrowClaim;
    @NotBlank
    @Size(min = 1,max = 50)

    private int bookID;
    @NotBlank
    @Size(min = 1,max = 50)

    private int userID;
}
