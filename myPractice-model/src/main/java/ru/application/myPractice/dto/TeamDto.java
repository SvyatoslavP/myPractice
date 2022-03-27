package ru.application.myPractice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TeamDto {
    private String persistenceId;
    private String teamName;
    private Set<PlayerDto> playerSet;
}
