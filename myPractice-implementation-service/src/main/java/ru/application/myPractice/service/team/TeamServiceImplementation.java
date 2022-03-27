package ru.application.myPractice.service.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Team;
import ru.application.myPractice.mapper.TeamMapper;
import ru.application.myPractice.repository.TeamRepository;
import ru.application.myPractice.services.team.TeamService;
import ru.application.myPractice.util.Objects;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class TeamServiceImplementation implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImplementation(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void save(TeamDto teamDto) {
        Team team = TeamMapper.MAPPER.toTeam(teamDto);
        Team alreadyExistingTeam = teamRepository.findByTeamName(team.getTeamName());
        if (Objects.isNull(alreadyExistingTeam)) {
            teamRepository.save(team);
        }
    }

    @Override
    public List<TeamDto> findAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(TeamMapper.MAPPER::teamToTeamDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDto findByTeamName(String teamName) {
        Team team = teamRepository.findByTeamName(teamName);
        return TeamMapper.MAPPER.teamToTeamDto(team);
    }
}
