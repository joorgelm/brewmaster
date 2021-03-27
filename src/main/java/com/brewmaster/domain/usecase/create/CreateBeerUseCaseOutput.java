package com.brewmaster.domain.usecase.create;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CreateBeerUseCaseOutput {
    private Long id;
    private String name;
    private String ingredients;
    private String alcoholContent;
    private BigDecimal price;
    private String category;
}
