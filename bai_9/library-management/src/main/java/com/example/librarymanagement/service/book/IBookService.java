package com.example.librarymanagement.service.book;

import com.example.librarymanagement.dto.BookDto;
import org.springframework.data.domain.Page;

public interface IBookService {
    Page<BookDto> findAll();
    BookDto findById(Long id);

}
