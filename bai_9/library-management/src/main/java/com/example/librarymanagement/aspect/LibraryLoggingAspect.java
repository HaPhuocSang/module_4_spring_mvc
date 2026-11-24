package com.example.librarymanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Aspect
@Component
public class LibraryLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LibraryLoggingAspect.class);
    private final AtomicLong visitorCount = new AtomicLong();
    @Before("execution(* com.example.librarymanagement.controller..*(..))")
    public void countVisitor(JoinPoint joinPoint) {
        visitorCount.incrementAndGet();
        long count = visitorCount.incrementAndGet();
        logger.info("Lượt truy cập thứ {} - Thao tác: {}", count, joinPoint.getSignature().toShortString());
    }
    @AfterReturning("execution(* com.example.librarymanagement.service.borrow.BorrowService.borrowBook(..))")
    public void logBorrow(JoinPoint joinPoint) {
        Long bookId = (Long) joinPoint.getArgs()[0];
        logger.info("THAY ĐỔI SỐ LƯỢNG SÁCH: Mượn sách có ID = {}", bookId);
    }
    @AfterReturning("execution(* com.example.librarymanagement.service.borrow.BorrowService.returnBook(..))")
    public void logReturn(JoinPoint joinPoint) {
        String code = (String) joinPoint.getArgs()[0];
        logger.info("THAY ĐỔI SỐ LƯỢNG SÁCH: Trả sách với mã = {}", code);
    }
}
