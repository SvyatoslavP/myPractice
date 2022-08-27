package ru.application.myPractice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TournamentDto {
    private Set<TeamDto> teamDtoSet;
}
