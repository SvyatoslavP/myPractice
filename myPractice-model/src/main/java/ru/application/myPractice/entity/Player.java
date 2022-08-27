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

/**
 * Участник
 */
@Entity
@Table(name = "player")
@Getter
@Setter
public class Player {

    @Builder.Default
    @Id
    @Column(name = "persistence_id")
    private String persistenceId = UUID.randomUUID().toString();
    @Column(name = "player_name")
    private String playerName;

    @SuppressWarnings("unused")
    @Builder
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
