package edu.bbte.bape.matchService.repository;

import edu.bbte.bape.matchService.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}