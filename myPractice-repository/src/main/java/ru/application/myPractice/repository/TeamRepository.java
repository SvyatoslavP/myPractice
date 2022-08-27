package ru.application.myPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.application.myPractice.entity.Team;

public interface TeamRepository extends JpaRepository<Team, String> {
    @Query("select t from Team t where t.teamName = ?1")
    Team findByTeamName(String teamName);
}
