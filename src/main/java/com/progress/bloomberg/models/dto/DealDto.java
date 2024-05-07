package com.progress.bloomberg.models.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealDto {

    @NotNull(message = "id of deal must not be null")
    private Long id;

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
}
