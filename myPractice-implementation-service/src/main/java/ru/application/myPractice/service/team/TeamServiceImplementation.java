package ru.application.myPractice.service.team;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Team;
import ru.application.myPractice.mapper.TeamMapper;
import ru.application.myPractice.repository.TeamRepository;
import ru.application.myPractice.services.team.TeamService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class TeamServiceImplementation implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public void save(TeamDto teamDto) {
        Team team = TeamMapper.MAPPER.toTeam(teamDto);
        //TODO: Приходит ответ с задержкой от БД, нужнок как то решить
        Team byTeamName = teamRepository.findByTeamName(team.getTeamName());
        if (Objects.isNull(byTeamName)) {
            teamRepository.save(team);
        } else {
            //такая команда уже существует
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
