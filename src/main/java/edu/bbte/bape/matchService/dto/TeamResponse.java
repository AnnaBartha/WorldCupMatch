package edu.bbte.bape.matchService.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamResponse {

    private Long id;

    private String name;

    private String countryCode;

    private Integer fifaRanking;
}