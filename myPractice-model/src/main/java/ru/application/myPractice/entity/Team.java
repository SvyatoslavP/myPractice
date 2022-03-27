package ru.application.myPractice.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OrderBy;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TEAMS")
@Data
@EqualsAndHashCode
public class Team {

    @Builder.Default
    @Id
    @Column(name = "PERSISTENCE_ID")
    private String persistenceId = UUID.randomUUID().toString();

    @Column(name = "TEAM_NAME", length = 32, unique = true)
    private String teamName;

    @ElementCollection(targetClass = Player.class)
    @CollectionTable(name = "PLAYERS")
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "NAME")),
            @AttributeOverride(name = "surname", column = @Column(name = "SURNAME")),
            @AttributeOverride(name = "age", column = @Column(name = "AGE")),
    })
    @OrderBy(clause = "surname desc")
    protected Set<Player> playerSet = new HashSet<>();

    @SuppressWarnings("unused")
    @Builder
    public Team(String teamName, Set<Player> playerSet) {
        this.teamName = teamName;
        this.playerSet = playerSet;
    }

    public Team() {
    }
}
