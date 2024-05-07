package com.progress.bloomberg.services.impl;

import com.progress.bloomberg.models.dto.DealDto;
import com.progress.bloomberg.models.entities.Deal;
import com.progress.bloomberg.repositories.DealRepository;
import com.progress.bloomberg.services.DealService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService {

    private final ModelMapper modelMapper;
    private final DealRepository dealRepository;


    @Override
    public DealDto create(Deal deal) {
        return null;
    }
}
