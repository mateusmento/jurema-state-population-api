package com.jurema.statepopulationapi.statepopulation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatePopulationRepository extends JpaRepository<StatePopulation, Integer> {
}
