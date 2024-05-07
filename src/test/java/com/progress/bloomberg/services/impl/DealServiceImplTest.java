package com.progress.bloomberg.services.impl;

import com.progress.bloomberg.exceptions.IdAlreadyExistsException;
import com.progress.bloomberg.models.dto.DealDto;
import com.progress.bloomberg.models.entities.Deal;
import com.progress.bloomberg.repositories.DealRepository;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class DealServiceImplTest {

    @Mock
    private DealRepository dealRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DealServiceImpl dealService;

    private Deal deal;

    private DealDto dealDto;

    @BeforeEach
    public void setUp() {
        deal = Deal.builder()
                .id("ABC")
                .fromCurrencyIsoCode("fromCode123")
                .toCurrencyIsoCode("toCode123")
                .timestamp(LocalDateTime.now())
                .dealAmount(120.50)
                .build();

        dealDto = DealDto.builder()
                .id("ABCDto")
                .fromCurrencyIsoCode("fromCode123Dto")
                .toCurrencyIsoCode("toCode123Dto")
                .timestamp(LocalDateTime.now())
                .dealAmount(150.50)
                .build();
    }

    @Test
    @DisplayName("Test create method when the id already exists")
    public void testCreateWhenIdAlreadyExists() {
        given(dealRepository.existsById("ABCDto")).willReturn(true);
        assertThatExceptionOfType(IdAlreadyExistsException.class)
                .isThrownBy(() -> dealService.create(dealDto))
                .withMessage("Deal with " + dealDto.getId() + " already exists");
    }

    @Test
    @DisplayName("Test create method when the insertion is successful")
    public void testCreateMethodSuccess() {
        given(modelMapper.map(dealDto, Deal.class)).willReturn(deal);
        given(dealRepository.existsById("ABCDto")).willReturn(false);
        given(dealRepository.save(deal)).willReturn(deal);
        given(modelMapper.map(deal, DealDto.class)).willReturn(dealDto);
        DealDto result = dealService.create(dealDto);
        assertThat(result).isEqualTo(dealDto);
        verify(dealRepository, times(1)).existsById("ABCDto");
        verify(dealRepository, times(1)).save(deal);
    }
}
