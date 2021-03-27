package com.brewmaster.domain.repository;

import com.brewmaster.domain.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {

}
