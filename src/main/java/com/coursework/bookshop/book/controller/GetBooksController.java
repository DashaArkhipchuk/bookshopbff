package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class GetBooksController {
    public final BookService bookService;
    @GetMapping("${app.api.path.book.getBooks}")
    public ModelAndView getAllBooks(){
        log.info("Book controller");

        List<BookDto> allBooks = bookService.getAllBooks();
        log.info(bookService.getAllBooks());

        Map<String, List<BookDto>> result=new HashMap<>();
        result.put("books",allBooks);
        ModelAndView modelandview = new ModelAndView("books", result, HttpStatus.OK);
        modelandview.addObject("deletebookobj", DeleteBookRequest.builder().build());
        return modelandview;

    }
}
