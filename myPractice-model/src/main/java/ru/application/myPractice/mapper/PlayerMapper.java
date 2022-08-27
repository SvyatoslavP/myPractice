package ru.application.myPractice.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.application.myPractice.dto.PlayerDto;
import ru.application.myPractice.entity.Player;

@Mapper
public interface PlayerMapper {

    PlayerMapper MAPPER = Mappers.getMapper(PlayerMapper.class);

    Player toPlayer(PlayerDto playerDto);

    @Mappings({
            @Mapping(source = "playerName", target = "playerName")
    })
    @InheritInverseConfiguration
    PlayerDto playerToPlayerDto(Player player);
}