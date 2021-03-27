package com.brewmaster.domain.usecase.get;

import com.brewmaster.domain.entity.Beer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetBeerUseCaseOutputList implements GetBeerUseCaseOutput {

    private List<Beer> beers;
}
