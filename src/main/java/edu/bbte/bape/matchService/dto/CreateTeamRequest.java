package edu.bbte.bape.matchService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTeamRequest {

    @NotBlank(message = "Team name is required")
    @Size(max = 100, message = "Team name can contain maximum 100 characters")
    private String name;

    @NotBlank(message = "Country code is required")
    @Size(min = 3, max = 3, message = "Country code must contain exactly 3 characters")
    private String countryCode;

    @NotNull(message = "FIFA ranking is required")
    private Integer fifaRanking;
}