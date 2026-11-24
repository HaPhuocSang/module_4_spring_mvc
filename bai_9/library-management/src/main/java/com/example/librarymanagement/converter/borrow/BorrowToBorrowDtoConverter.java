package com.example.librarymanagement.converter.borrow;

import com.example.librarymanagement.dto.BorrowDto;
import com.example.librarymanagement.entity.BorrowRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BorrowToBorrowDtoConverter implements Converter<BorrowRecord, BorrowDto> {
    @Override
    public BorrowDto convert(BorrowRecord borrowRecord) {
        return new BorrowDto(borrowRecord.getId(), borrowRecord.getBorrowCode(), borrowRecord.getBook(), borrowRecord.getReturned(), borrowRecord.getBorrowDate(), borrowRecord.getReturnDate());
    }
}
