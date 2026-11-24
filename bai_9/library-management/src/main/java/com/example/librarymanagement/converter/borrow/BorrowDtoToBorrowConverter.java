package com.example.librarymanagement.converter.borrow;

import com.example.librarymanagement.dto.BorrowDto;
import com.example.librarymanagement.entity.BorrowRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BorrowDtoToBorrowConverter implements Converter<BorrowDto, BorrowRecord> {
    @Override
    public BorrowRecord convert(BorrowDto borrowDto) {
        return new BorrowRecord(borrowDto.getId(), borrowDto.getBorrowCode(), borrowDto.getBook(), borrowDto.getReturned(), borrowDto.getBorrowDate(), borrowDto.getReturnDate());
    }
}
