package ru.application.myPractice.entity;

import com.google.common.collect.Lists;
import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * Турнир
 */
@Entity
@Table(name = "tournament")
public class Tournament {

    @Builder.Default
    @Id
    @Column(name = "persistence_id")
    private String persistenceId = UUID.randomUUID().toString();
    /**
     * список команд
     */
    @OneToMany(targetEntity = Team.class, cascade = CascadeType.ALL)
    List<Team> teamList = Lists.newArrayList();

}
