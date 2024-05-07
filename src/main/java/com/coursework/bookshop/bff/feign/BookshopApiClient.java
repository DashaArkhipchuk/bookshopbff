package com.coursework.bookshop.bff.feign;

import com.coursework.bookshop.book.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("BOOKSHOP")
public interface BookshopApiClient {

    @GetMapping("${app.api.version.bookshop}${app.api.path.book.getBooks}")
    List<BookDto> getBooks();

}
