package edu.bbte.bape.matchService.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamSummaryResponse {

    private Long id;

    private String name;
}