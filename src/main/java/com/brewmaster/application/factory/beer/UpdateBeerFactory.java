package com.brewmaster.application.factory.beer;

import com.brewmaster.domain.repository.BeerRepository;
import com.brewmaster.domain.usecase.update.UpdateBeerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateBeerFactory {

    @Bean
    public UpdateBeerUseCase factoryUpdateBeerUseCase(BeerRepository beerRepository) {
        return UpdateBeerUseCase.builder()
                .beerRepository(beerRepository)
                .build();
    }
}
