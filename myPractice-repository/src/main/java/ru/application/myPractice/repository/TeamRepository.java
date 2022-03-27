package ru.application.myPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.application.myPractice.entity.Team;

public interface TeamRepository extends JpaRepository<Team, String> {
    Team findByTeamName(String teamName);
}
