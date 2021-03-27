package com.brewmaster.domain.usecase.get;

import com.brewmaster.domain.entity.Beer;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetBeerUseCaseOutputSingle implements GetBeerUseCaseOutput {

    private Beer beer;
}
