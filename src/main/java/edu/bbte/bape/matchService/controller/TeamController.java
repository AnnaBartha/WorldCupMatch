package edu.bbte.bape.matchService.controller;

import edu.bbte.bape.matchService.dto.CreateTeamRequest;
import edu.bbte.bape.matchService.dto.TeamResponse;
import edu.bbte.bape.matchService.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public TeamResponse createTeam(
            @Valid @RequestBody CreateTeamRequest request
    ) {
        return teamService.createTeam(request);
    }

    @GetMapping
    public List<TeamResponse> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public TeamResponse getTeamById(
            @PathVariable Long id
    ) {
        return teamService.getTeamById(id);
    }
}