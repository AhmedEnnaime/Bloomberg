package com.progress.bloomberg.controllers;

import com.progress.bloomberg.models.dto.DealDto;
import com.progress.bloomberg.services.DealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/deals", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class DealController {

    private final DealService dealService;

    @PostMapping
    public ResponseEntity<DealDto> createDeal(@Valid @RequestBody DealDto dealDto) {
        DealDto createdDeal = dealService.create(dealDto);
        return new ResponseEntity<>(createdDeal, HttpStatus.CREATED);
    }
}
