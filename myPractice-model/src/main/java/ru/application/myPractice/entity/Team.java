package ru.application.myPractice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TEAMS")
@Getter
@Setter
public class Team {

    @Builder.Default
    @Id
    @Column(name = "PERSISTENCE_ID")
    private String persistenceId = UUID.randomUUID().toString();

    @Column(name = "TEAM_NAME", length = 32)
    private String teamName;

    @Builder
    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamName.equals(team.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
