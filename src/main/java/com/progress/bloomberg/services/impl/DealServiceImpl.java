package com.progress.bloomberg.services.impl;

import com.progress.bloomberg.exceptions.IdAlreadyExistsException;
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
    public DealDto create(DealDto deal) {
        if(dealRepository.existsById(deal.getId()))
            throw new IdAlreadyExistsException("Deal with " + deal.getId() + " already exists");
        Deal newDeal = modelMapper.map(deal, Deal.class);
        Deal savedDeal = dealRepository.save(newDeal);
        return modelMapper.map(savedDeal, DealDto.class);
    }
}
