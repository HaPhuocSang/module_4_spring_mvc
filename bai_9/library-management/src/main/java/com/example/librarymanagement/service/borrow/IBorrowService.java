package com.example.librarymanagement.service.borrow;

public interface IBorrowService {
    String borrowBook(Long bookId);
    void returnBook(String code);
}
