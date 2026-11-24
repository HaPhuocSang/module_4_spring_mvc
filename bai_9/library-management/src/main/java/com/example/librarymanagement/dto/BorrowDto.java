package com.example.librarymanagement.dto;

import com.example.librarymanagement.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BorrowDto {
    private Long id;
    private String borrowCode;
    private Book book;
    private Boolean returned;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
}
