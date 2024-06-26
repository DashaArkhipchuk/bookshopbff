package com.coursework.bookshop.author.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    private String biography;
    private String activityYears;
}
