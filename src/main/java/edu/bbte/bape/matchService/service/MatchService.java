package edu.bbte.bape.matchService.service;

import edu.bbte.bape.matchService.dto.CreateMatchRequest;
import edu.bbte.bape.matchService.dto.MatchResponse;
import edu.bbte.bape.matchService.dto.TeamSummaryResponse;
import edu.bbte.bape.matchService.dto.UpdateMatchResultRequest;
import edu.bbte.bape.matchService.entity.Match;
import edu.bbte.bape.matchService.entity.MatchStatus;
import edu.bbte.bape.matchService.entity.Team;
import edu.bbte.bape.matchService.exception.MatchNotFoundException;
import edu.bbte.bape.matchService.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    private final TeamService teamService;

    public MatchResponse createMatch(CreateMatchRequest request) {
        Team homeTeam = teamService.getTeamEntityById(request.getHomeTeamId());
        Team awayTeam = teamService.getTeamEntityById(request.getAwayTeamId());

        if (homeTeam.getId().equals(awayTeam.getId())) {
            throw new RuntimeException("Home team and away team cannot be the same");
        }

        Match match = Match.builder()
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .matchDate(request.getMatchDate())
                .status(MatchStatus.SCHEDULED)
                .build();

        Match savedMatch = matchRepository.save(match);

        return mapToResponse(savedMatch);
    }

    public List<MatchResponse> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public MatchResponse getMatchById(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));

        return mapToResponse(match);
    }

    public MatchResponse updateMatchResult(Long id, UpdateMatchResultRequest request) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));

        match.setHomeScore(request.getHomeScore());
        match.setAwayScore(request.getAwayScore());
        match.setStatus(MatchStatus.FINISHED);

        Match savedMatch = matchRepository.save(match);

        return mapToResponse(savedMatch);
    }

    private MatchResponse mapToResponse(Match match) {
        return MatchResponse.builder()
                .id(match.getId())
                .homeTeam(mapTeamToSummary(match.getHomeTeam()))
                .awayTeam(mapTeamToSummary(match.getAwayTeam()))
                .matchDate(match.getMatchDate())
                .homeScore(match.getHomeScore())
                .awayScore(match.getAwayScore())
                .status(match.getStatus())
                .build();
    }

    private TeamSummaryResponse mapTeamToSummary(Team team) {
        return TeamSummaryResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }
}