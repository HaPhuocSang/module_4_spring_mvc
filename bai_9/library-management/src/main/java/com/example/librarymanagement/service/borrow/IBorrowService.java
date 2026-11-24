package com.example.librarymanagement.service.borrow;

import com.example.librarymanagement.dto.BorrowDto;

public interface IBorrowService {
    BorrowDto borrowBook(Long bookId);
    void returnBook(String code);
}
