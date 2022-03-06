package ru.application.myPractice.service.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.application.myPractice.entity.Team;
import ru.application.myPractice.repository.TeamRepository;
import ru.application.myPractice.services.team.TeamService;

@Service
@Transactional
public class TeamServiceImplementation implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImplementation(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }
}
