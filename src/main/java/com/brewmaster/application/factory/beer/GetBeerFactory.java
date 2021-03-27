package com.brewmaster.application.factory.beer;

import com.brewmaster.domain.repository.BeerRepository;
import com.brewmaster.domain.usecase.get.GetBeerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetBeerFactory {

    @Bean
    public GetBeerUseCase factoryGetBeerUseCase(BeerRepository beerRepository) {
        return GetBeerUseCase.builder()
                .beerRepository(beerRepository)
                .build();
    }
}
