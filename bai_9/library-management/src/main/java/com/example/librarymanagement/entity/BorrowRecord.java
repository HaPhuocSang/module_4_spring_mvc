package com.example.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_records")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "borrow_code", nullable = false, unique = true)
    private String borrowCode;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    private Boolean returned;
    @Column(name = "borrow_date")
    private LocalDateTime borrowDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @PrePersist
    public void prePersist() {
        this.borrowDate = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.returnDate = LocalDateTime.now();
    }
}
