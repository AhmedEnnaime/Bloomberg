package com.progress.bloomberg.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "deals")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromCurrencyIsoCode;

    @Column(nullable = false)
    private String toCurrencyIsoCode;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private Double dealAmount;
}
