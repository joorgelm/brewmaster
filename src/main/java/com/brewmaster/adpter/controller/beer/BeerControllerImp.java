package com.brewmaster.adpter.controller.beer;

import com.brewmaster.domain.usecase.create.CreateBeerUseCase;
import com.brewmaster.domain.usecase.create.CreateBeerUseCaseInput;
import com.brewmaster.domain.usecase.create.CreateBeerUseCaseOutput;
import com.brewmaster.domain.usecase.delete.DeleteBeerUseCase;
import com.brewmaster.domain.usecase.get.GetBeerUseCase;
import com.brewmaster.domain.usecase.get.GetBeerUseCaseOutput;
import com.brewmaster.domain.usecase.update.UpdateBeerUseCase;
import com.brewmaster.domain.usecase.update.UpdateBeerUseCaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BeerControllerImp implements BeerController {

    @Autowired
    private GetBeerUseCase getBeerUseCase;

    @Autowired
    private CreateBeerUseCase createBeerUseCase;

    @Autowired
    private UpdateBeerUseCase updateBeerUseCase;

    @Autowired
    private DeleteBeerUseCase deleteBeerUseCase;

    @Override
    public ResponseEntity<GetBeerUseCaseOutput> get(Long beerId) {
        GetBeerUseCaseOutput output = getBeerUseCase.get(beerId);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateBeerUseCaseOutput> create(CreateBeerUseCaseInput createBeerInput) {
        CreateBeerUseCaseOutput output = createBeerUseCase.execute(createBeerInput);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> update(Long beerId, UpdateBeerUseCaseInput updateBeerInput) throws IllegalAccessException {
        updateBeerUseCase.update(beerId, updateBeerInput);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> updateAll(Long beerId, UpdateBeerUseCaseInput updateBeerInput) {
        updateBeerInput.setId(beerId);
        updateBeerUseCase.updateAll(updateBeerInput);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> delete(Long beerId) {
        deleteBeerUseCase.execute(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
