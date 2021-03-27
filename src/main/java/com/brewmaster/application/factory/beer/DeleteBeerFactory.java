package com.brewmaster.application.factory.beer;

import com.brewmaster.domain.repository.BeerRepository;
import com.brewmaster.domain.usecase.delete.DeleteBeerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteBeerFactory {

    @Bean
    public DeleteBeerUseCase factoryDeleteBeerUseCase(BeerRepository beerRepository) {
        return DeleteBeerUseCase.builder()
                .beerRepository(beerRepository)
                .build();
    }
}
