package ru.application.myPractice.dto;

import lombok.Builder;
import lombok.Data;
import ru.application.myPractice.entity.Team;
@Data
@Builder
public class PlayerDto {
    private String name;
    private String surname;
    private int age;
    private Team team;
}
