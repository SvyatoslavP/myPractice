package ru.application.myPractice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeamDto {
    private String teamName;
    private List<PlayerDto> playerList;
}
