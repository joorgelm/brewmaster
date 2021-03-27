package com.brewmaster.domain.usecase.delete;

import com.brewmaster.domain.entity.Beer;
import com.brewmaster.domain.repository.BeerRepository;
import lombok.Builder;

import javax.persistence.EntityNotFoundException;

@Builder
public class DeleteBeerUseCase {

    private BeerRepository beerRepository;

    public void execute(long beerId) {

        beerRepository.delete(getBeer(beerId));
    }

    private Beer getBeer(long id) {
        return beerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cerveja não encontrada"));
    }
}
