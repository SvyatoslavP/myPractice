package ru.application.myPractice.services.team;

import ru.application.myPractice.dto.TeamDto;

import java.util.List;

public interface TeamService {

    void save(TeamDto team);

    List<TeamDto> findAll();

    TeamDto findByTeamName(String teamName);

}
