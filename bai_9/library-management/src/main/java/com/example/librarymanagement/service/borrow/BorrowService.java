package com.example.librarymanagement.service.borrow;

import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.BorrowRecord;
import com.example.librarymanagement.repository.IBookRepository;
import com.example.librarymanagement.repository.IBorrowRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BorrowService implements IBorrowService {
    private final IBorrowRecordRepository borrowRecordRepository;
    private final IBookRepository bookRepository;

    public BorrowService(IBorrowRecordRepository borrowRecordRepository, IBookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
    }
    private String generateBorrowCode() {
        String code;
        do {
            code = String.format("%05d", new Random().nextInt(100000));
        } while (borrowRecordRepository.findByBorrowCode(code).isPresent());
        return code;
    }
    @Override
    @Transactional
    public String borrowBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sách!"));
        if (book.getQuantity() == null || book.getQuantity() <= 0) {
            throw new IllegalStateException("Sách đã hết, vui lòng trọn sách khác!");
        }
        String code =  generateBorrowCode();
        BorrowRecord record = new BorrowRecord();
        record.setBorrowCode(code);
        record.setBook(book);
        record.setReturned(false);
        bookRepository.save(book);
        borrowRecordRepository.save(record);
        return code;
    }

    @Override
    @Transactional
    public void returnBook(String code) {
        if (code == null || !code.matches("\\d{5}")) {
            throw new IllegalArgumentException("Mã mượn phải gồm đúng 5 chữ số!");
        }
        BorrowRecord record = borrowRecordRepository.findByBorrowCode(code).orElseThrow(() -> new IllegalArgumentException("Mã mượn không tồn tại!"));
        if (Boolean.TRUE.equals(record.getReturned())) {
            throw new IllegalStateException("Sách đã được trả trước đó!");
        }
        Book book = bookRepository.findById(record.getBook().getId()).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sách!"));
        book.setQuantity(book.getQuantity() + 1);
        record.setReturned(true);
        bookRepository.save(book);
        borrowRecordRepository.save(record);
    }
}
