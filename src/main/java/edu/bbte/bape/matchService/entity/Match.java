package edu.bbte.bape.matchService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Home team of the match
    @ManyToOne(optional = false)
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    // Away team of the match
    @ManyToOne(optional = false)
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    // Planned match date and time
    @Column(nullable = false)
    private LocalDateTime matchDate;

    // Home team final score
    private Integer homeScore;

    // Away team final score
    private Integer awayScore;

    // Current match status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchStatus status;
}