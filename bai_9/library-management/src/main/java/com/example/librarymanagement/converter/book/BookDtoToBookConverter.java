package com.example.librarymanagement.converter.book;

import com.example.librarymanagement.dto.BookDto;
import com.example.librarymanagement.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDtoToBookConverter implements Converter<BookDto, Book> {
    @Override
    public Book convert(BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getDescription(), bookDto.getQuantity());
    }
}
