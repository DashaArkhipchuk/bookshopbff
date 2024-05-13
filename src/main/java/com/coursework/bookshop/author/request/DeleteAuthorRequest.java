package com.coursework.bookshop.author.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAuthorRequest {
    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Integer id;
}
