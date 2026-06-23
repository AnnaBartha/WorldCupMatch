package edu.bbte.bape.matchService.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateMatchRequest {

    @NotNull(message = "Home team id is required")
    private Long homeTeamId;

    @NotNull(message = "Away team id is required")
    private Long awayTeamId;

    @NotNull(message = "Match date is required")
    @Future(message = "Match date must be in the future")
    private LocalDateTime matchDate;
}