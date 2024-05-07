package com.progress.bloomberg.models.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DealDto {

    @NotNull(message = "id must not be null")
    @NotEmpty(message = "id must not be empty")
    private String id;

    @NotNull(message = "From Ordering currency iso code must not be null")
    @NotEmpty(message = "From Ordering currency iso code must not be empty")
    @Size(max = 255, min = 3, message = "From Ordering currency iso code should be between 3 and 255 character.")
    private String  fromCurrencyIsoCode;

    @NotNull(message = "To Ordering currency iso code must not be null")
    @NotEmpty(message = "To Ordering currency iso code must not be empty")
    @Size(max = 255, min = 3, message = "To Ordering currency iso code should be between 3 and 255 character.")
    private String  toCurrencyIsoCode;

    @NotNull(message = "Deal amount must not be null")
    @Min(value = 0, message = "deal amount should not be less than 0.")
    private Double dealAmount;

    private LocalDateTime timestamp;
}
