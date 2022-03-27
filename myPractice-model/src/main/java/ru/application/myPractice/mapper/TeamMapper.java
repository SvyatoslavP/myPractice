package ru.application.myPractice.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Team;

@Mapper(uses = {PlayerMapper.class})
public interface TeamMapper {

    TeamMapper MAPPER = Mappers.getMapper(TeamMapper.class);

    Team toTeam(TeamDto teamDto);

    @InheritInverseConfiguration
    TeamDto teamToTeamDto(Team team);
}
