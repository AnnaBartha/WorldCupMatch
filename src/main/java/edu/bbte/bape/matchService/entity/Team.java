package edu.bbte.bape.matchService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // c sapatnev
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    // rovidites az orszagkoddal ARG, BRA, FRA
    @Column(nullable = false, unique = true, length = 3)
    private String countryCode;

    // fifa ranking
    @Column(nullable = false)
    private Integer fifaRanking;
}