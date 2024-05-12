package com.coursework.bookshop.author.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
}
