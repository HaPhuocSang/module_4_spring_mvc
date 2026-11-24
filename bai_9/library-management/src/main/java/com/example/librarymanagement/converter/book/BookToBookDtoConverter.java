package com.example.librarymanagement.converter.book;

import com.example.librarymanagement.dto.BookDto;
import com.example.librarymanagement.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDtoConverter implements Converter<Book, BookDto> {
    @Override
    public BookDto convert(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getQuantity());
    }
}
