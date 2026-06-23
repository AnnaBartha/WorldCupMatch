package edu.bbte.bape.matchService.service;

import edu.bbte.bape.matchService.dto.CreateTeamRequest;
import edu.bbte.bape.matchService.dto.TeamResponse;
import edu.bbte.bape.matchService.entity.Team;
import edu.bbte.bape.matchService.exception.TeamAlreadyExistsException;
import edu.bbte.bape.matchService.exception.TeamNotFoundException;
import edu.bbte.bape.matchService.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamResponse createTeam(CreateTeamRequest request) {
        if (teamRepository.existsByName(request.getName())) {
            throw new TeamAlreadyExistsException("Team name already exists");
        }

        if (teamRepository.existsByCountryCode(request.getCountryCode())) {
            throw new TeamAlreadyExistsException("Country code already exists");
        }

        Team team = Team.builder()
                .name(request.getName())
                .countryCode(request.getCountryCode().toUpperCase())
                .fifaRanking(request.getFifaRanking())
                .build();

        Team savedTeam = teamRepository.save(team);

        return mapToResponse(savedTeam);
    }

    public List<TeamResponse> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TeamResponse getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));

        return mapToResponse(team);
    }

    public Team getTeamEntityById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    private TeamResponse mapToResponse(Team team) {
        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .countryCode(team.getCountryCode())
                .fifaRanking(team.getFifaRanking())
                .build();
    }
}