package ru.application.myPractice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@Embeddable
public class Player {

    protected String name;
    protected String surname;
    protected int age;

    @org.hibernate.annotations.Parent
    protected Team team;
}
