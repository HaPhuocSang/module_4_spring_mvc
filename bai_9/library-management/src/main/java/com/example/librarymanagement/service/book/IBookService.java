package com.example.librarymanagement.service.book;

import com.example.librarymanagement.dto.BookDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IBookService {
    Page<BookDto> findAll(Integer page, Integer size, String direction);
    Optional<BookDto> findById(Long id);

}
