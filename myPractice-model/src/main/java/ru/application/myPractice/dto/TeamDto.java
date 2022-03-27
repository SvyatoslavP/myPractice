package ru.application.myPractice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode
@Builder
public class TeamDto {
    private String persistenceId;
    private String teamName;
    private Set<PlayerDto> playerSet;
}
