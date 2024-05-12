package com.coursework.bookshop.author.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAuthorRequest {
    private Integer id;
    private String firstName;
    private String lastName;

    private String biography;
    private String activityYears;
}
