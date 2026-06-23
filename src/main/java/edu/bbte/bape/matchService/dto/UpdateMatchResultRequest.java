package edu.bbte.bape.matchService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMatchResultRequest {

    @NotNull(message = "Home score is required")
    @Min(value = 0, message = "Home score cannot be negative")
    private Integer homeScore;

    @NotNull(message = "Away score is required")
    @Min(value = 0, message = "Away score cannot be negative")
    private Integer awayScore;
}