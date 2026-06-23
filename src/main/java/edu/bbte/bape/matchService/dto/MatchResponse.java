package edu.bbte.bape.matchService.dto;

import edu.bbte.bape.matchService.entity.MatchStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MatchResponse {

    private Long id;

    private TeamSummaryResponse homeTeam;

    private TeamSummaryResponse awayTeam;

    private LocalDateTime matchDate;

    private Integer homeScore;

    private Integer awayScore;

    private MatchStatus status;
}