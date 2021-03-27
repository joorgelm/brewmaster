package com.brewmaster.domain.usecase.update;

import com.brewmaster.domain.entity.Beer;
import com.brewmaster.domain.helper.Validator;
import com.brewmaster.domain.repository.BeerRepository;
import lombok.Builder;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Builder
public class UpdateBeerUseCase {
    private BeerRepository beerRepository;

    public void update(long id, UpdateBeerUseCaseInput input) throws IllegalAccessException {

        partialValidate(input);

        input.setId(id);

        Beer beerToUpdate = getBeer(input);

        update(input, beerToUpdate);

        beerRepository.save(beerToUpdate);
    }

    private void partialValidate(UpdateBeerUseCaseInput input) throws IllegalAccessException {
        if (input.checkNull())
            throw new IllegalStateException("Nenhuma informação válida");
    }

    private static void update(UpdateBeerUseCaseInput input, Beer beerToUpdate) {
        Optional.ofNullable(input.getName()).ifPresent(beerToUpdate::setName);
        Optional.ofNullable(input.getPrice()).ifPresent(beerToUpdate::setPrice);
        Optional.ofNullable(input.getAlcoholContent()).ifPresent(beerToUpdate::setAlcoholContent);
        Optional.ofNullable(input.getCategory()).ifPresent(beerToUpdate::setAlcoholContent);
        Optional.ofNullable(input.getIngredients()).ifPresent(beerToUpdate::setIngredients);
    }

    private Beer getBeer(UpdateBeerUseCaseInput input) {
        return beerRepository.findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cerveja não encontrada"));
    }

    public void updateAll(UpdateBeerUseCaseInput input) {
        validate(input);

        Beer beerToUpdate = getBeer(input);

        update(input, beerToUpdate);

        beerRepository.save(beerToUpdate);
    }

    private static void validate(UpdateBeerUseCaseInput input) {
        Validator.of(input)
                .validate(UpdateBeerUseCaseInput::getName, Objects::nonNull, "Nome não informado")
                .validate(UpdateBeerUseCaseInput::getAlcoholContent, Objects::nonNull, "Teor alcoolico não informado")
                .validate(UpdateBeerUseCaseInput::getCategory, Objects::nonNull, "Categoria não informada")
                .validate(UpdateBeerUseCaseInput::getIngredients, Objects::nonNull, "Ingredientes não informados")
                .validate(UpdateBeerUseCaseInput::getPrice, Objects::nonNull, "Preço não informado");
    }
}
