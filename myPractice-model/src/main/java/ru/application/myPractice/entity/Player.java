package ru.application.myPractice.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Objects;

@Data
@Embeddable
public class Player {

    protected String name;
    protected String surname;
    protected int age;

    @org.hibernate.annotations.Parent
    protected Team team;

    @SuppressWarnings("unused")
    @Builder
    public Player(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Player() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && Objects.equals(name, player.name) && Objects.equals(surname, player.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
