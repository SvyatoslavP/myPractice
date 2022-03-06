package ru.application.myPractice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Team;

@Mapper
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamDto teamToTeamDto(Team team);
}
