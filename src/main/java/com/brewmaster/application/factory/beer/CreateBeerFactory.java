package com.brewmaster.application.factory.beer;

import com.brewmaster.domain.repository.BeerRepository;
import com.brewmaster.domain.usecase.create.CreateBeerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBeerFactory {

    @Bean
    public CreateBeerUseCase factoryCreateBeerUseCase(BeerRepository beerRepository) {
        return CreateBeerUseCase.builder()
                .beerRepository(beerRepository)
                .build();
    }
}
