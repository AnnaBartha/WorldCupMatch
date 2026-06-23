package edu.bbte.bape.matchService.repository;

import edu.bbte.bape.matchService.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    boolean existsByName(String name);

    boolean existsByCountryCode(String countryCode);
}