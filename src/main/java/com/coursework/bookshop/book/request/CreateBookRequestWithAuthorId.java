package com.coursework.bookshop.book.request;

import com.coursework.bookshop.author.request.CreateAuthorRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookRequestWithAuthorId {
    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Publish year is required")
    @Min(value = 1000, message = "Publish year must be greater than or equal to 1000")
    @Max(value = 2024, message = "Publish year must be less than or equal to 2024")
    private Integer publishYear;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price must be greater than or equal to 0.0")
    private Double price;

    @NotNull(message = "Author id is required")
    @Min(value = 1, message = "Author id must be greater than or equal to 1")
    private Integer authorId;
}
