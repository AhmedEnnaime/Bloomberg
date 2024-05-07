package com.progress.bloomberg.services;

import com.progress.bloomberg.models.dto.DealDto;
import com.progress.bloomberg.models.entities.Deal;

public interface DealService {
    DealDto create(Deal deal);
}
