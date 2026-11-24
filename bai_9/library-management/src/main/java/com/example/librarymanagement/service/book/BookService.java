package com.example.librarymanagement.service.book;

import com.example.librarymanagement.converter.book.BookDtoToBookConverter;
import com.example.librarymanagement.converter.book.BookToBookDtoConverter;
import com.example.librarymanagement.dto.BookDto;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.IBookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    private final BookToBookDtoConverter bookToBookDtoConverter;

    public BookService(IBookRepository bookRepository, BookToBookDtoConverter bookToBookDtoConverter, BookDtoToBookConverter bookDtoToBookConverter) {
        this.bookRepository = bookRepository;
        this.bookToBookDtoConverter = bookToBookDtoConverter;
    }

    @Override
    public Page<BookDto> findAll(Integer page, Integer size, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, "id") : Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookRepository.findAll(pageable).map(bookToBookDtoConverter::convert);
    }

    @Override
    public Optional<BookDto> findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookToBookDtoConverter::convert);
    }
}
