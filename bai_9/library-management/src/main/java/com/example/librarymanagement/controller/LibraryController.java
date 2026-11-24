package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.BookDto;
import com.example.librarymanagement.service.book.IBookService;
import com.example.librarymanagement.service.borrow.IBorrowService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LibraryController {
    private final IBookService bookService;
    private final IBorrowService borrowService;

    public LibraryController(IBookService bookService, IBorrowService borrowService) {
        this.bookService = bookService;
        this.borrowService = borrowService;
    }

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<BookDto> books = bookService.findAll(page, 6, "desc");
        model.addAttribute("books", books);
        return "index";
    }
    @GetMapping("/{id}/books")
    public String detail(@PathVariable("id") Long id, Model model) {
        BookDto book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đầu sách!"));
        model.addAttribute("book", book);
        return "detail";
    }

    @PostMapping("/{id}/books/borrow")
    public String borrow(@PathVariable("id") Long id, Model model) {
        String code = borrowService.borrowBook(id);
        BookDto book = bookService.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("borrowCode", code);
        return "borrow-success";
    }

    @GetMapping("/return")
    public String returnForm() {
        return "return-book";
    }
    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode, Model model) {
        borrowService.returnBook(borrowCode.trim());
        model.addAttribute("message", "Trả sách thành công!");
        return "return-success";
    }
}
