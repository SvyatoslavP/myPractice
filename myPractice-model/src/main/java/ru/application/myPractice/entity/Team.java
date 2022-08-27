package ru.application.myPractice.entity;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Команда
 */
@Entity
@Table(name = "team")
@Setter
@Getter
public class Team {

    @Builder.Default
    @Id
    @Column(name = "persistence_id")
    private String persistenceId = UUID.randomUUID().toString();

    @Column(name = "team_name", length = 32, unique = true)
    private String teamName;
    /**
     * Список игроков
     */
    @OneToMany(targetEntity = Player.class, cascade = CascadeType.ALL)
    private List<Player> playerList = Lists.newArrayList();

    @SuppressWarnings("unused")
    @Builder
    public Team(String teamName, List<Player> playerList) {
        this.teamName = teamName;
        this.playerList = playerList;
    }

    public Team() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) && Objects.equals(playerList, team.playerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, playerList);
    }
}
