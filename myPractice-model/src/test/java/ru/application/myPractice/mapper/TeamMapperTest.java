package ru.application.myPractice.mapper;

import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.application.myPractice.dto.PlayerDto;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Player;
import ru.application.myPractice.entity.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

@RunWith(MockitoJUnitRunner.class)
public class TeamMapperTest {

    @Test
    public void shouldMapperTeamToTeamDto() {
        //given
        Set<Player> players = new HashSet<>(List.of(Player.builder()
                .age(18)
                .name("Petya")
                .surname("Petrov")
                .build()));
        Team team = Team.builder()
                .teamName("Los Angeles")
                .playerSet(players)
                .build();
        //when
        TeamDto teamDto = TeamMapper.MAPPER.teamToTeamDto(team);
        //then
        assertThat(teamDto).isNotNull();
        assertThat(teamDto.getPersistenceId()).isNotNull();
        assertThat(teamDto.getTeamName()).isEqualTo("Los Angeles");
        assertThat(teamDto.getPlayerSet().stream().findFirst().orElse(null))
                .extracting(dto -> Tuple.tuple(
                        dto.getName(),
                        dto.getAge(),
                        dto.getSurname(),
                        dto.getTeam())
                ).isEqualTo(tuple(
                        "Petya",
                        18,
                        "Petrov",
                        null)
                );
    }

    @Test
    public void shouldMapperTeamDtoToTeam() {
        //given
        Set<PlayerDto> players = new HashSet<>(List.of(PlayerDto.builder()
                .age(18)
                .name("Petya")
                .surname("Petrov")
                .build()));
        TeamDto teamDto = TeamDto.builder()
                .teamName("Los Angeles")
                .playerSet(players)
                .build();
        //when
        Team team = TeamMapper.MAPPER.toTeam(teamDto);
        //then
        assertThat(team).isNotNull();
        assertThat(team.getPersistenceId()).isNotNull();
        assertThat(team.getTeamName()).isEqualTo("Los Angeles");
        assertThat(team.getPlayerSet().stream().findFirst().orElse(null))
                .extracting(player -> Tuple.tuple(
                        player.getName(),
                        player.getAge(),
                        player.getSurname(),
                        player.getTeam())
                ).isEqualTo(tuple(
                        "Petya",
                        18,
                        "Petrov",
                        null)
                );
    }

    @Test
    public void shouldMapperPlayerDtoToPlayer() {
        //given
        PlayerDto playerDto = PlayerDto.builder()
                .age(18)
                .name("Petya")
                .surname("Petrov")
                .build();
        //when
        Player player = PlayerMapper.MAPPER.toPlayer(playerDto);
        //then
        assertThat(player)
                .isNotNull()
                .extracting(pl -> Tuple.tuple(
                        pl.getAge(),
                        pl.getTeam(),
                        pl.getName(),
                        pl.getSurname()
                )).isEqualTo(tuple(
                        18,
                        null,
                        "Petya",
                        "Petrov"
                ));
    }

    @Test
    public void shouldMapperPlayerToPlayerDto() {
        //given
        Player player = Player.builder()
                .age(18)
                .name("Petya")
                .surname("Petrov")
                .build();
        //when
        PlayerDto playerDto = PlayerMapper.MAPPER.playerToPlayerDto(player);
        //then
        assertThat(playerDto)
                .isNotNull()
                .extracting(pl -> Tuple.tuple(
                        pl.getAge(),
                        pl.getTeam(),
                        pl.getName(),
                        pl.getSurname()
                )).isEqualTo(tuple(
                        18,
                        null,
                        "Petya",
                        "Petrov"
                ));
    }

}