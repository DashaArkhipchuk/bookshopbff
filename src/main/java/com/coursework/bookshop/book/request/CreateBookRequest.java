package com.coursework.bookshop.book.request;

import com.coursework.bookshop.author.request.CreateAuthorRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookRequest {
    private String title;
    private int publishYear;
    private String genre;
    private Double price;

    private CreateAuthorRequest author;

}
