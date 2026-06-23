package edu.bbte.bape.matchService.controller;

import edu.bbte.bape.matchService.dto.CreateMatchRequest;
import edu.bbte.bape.matchService.dto.MatchResponse;
import edu.bbte.bape.matchService.dto.UpdateMatchResultRequest;
import edu.bbte.bape.matchService.service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    public MatchResponse createMatch(
            @Valid @RequestBody CreateMatchRequest request
    ) {
        return matchService.createMatch(request);
    }

    @GetMapping
    public List<MatchResponse> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public MatchResponse getMatchById(
            @PathVariable Long id
    ) {
        return matchService.getMatchById(id);
    }

    @PutMapping("/{id}/result")
    public MatchResponse updateMatchResult(
            @PathVariable Long id,
            @Valid @RequestBody UpdateMatchResultRequest request
    ) {
        return matchService.updateMatchResult(id, request);
    }
}