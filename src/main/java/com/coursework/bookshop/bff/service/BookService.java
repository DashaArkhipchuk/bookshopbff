package com.coursework.bookshop.bff.service;

import com.coursework.bookshop.bff.feign.BookshopApiClient;
import com.coursework.bookshop.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookshopApiClient bookshopApiClient;
    public List<BookDto> getAllBooks(){
        return bookshopApiClient.getBooks();
    }

}
