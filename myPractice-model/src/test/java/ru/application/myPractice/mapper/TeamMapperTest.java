package ru.application.myPractice.mapper;

import com.google.common.collect.Lists;
import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.application.myPractice.dto.PlayerDto;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Player;
import ru.application.myPractice.entity.Team;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

@RunWith(MockitoJUnitRunner.class)
public class TeamMapperTest {

    @Test
    public void shouldMapperTeamToTeamDto() {
        //given
        List<Player> players = Lists.newArrayList(Player.builder()
                .playerName("Vladimir")
                .build());
        Team team = Team.builder()
                .teamName("Los Angeles")
                .playerList(players)
                .build();
        //when
        TeamDto teamDto = TeamMapper.MAPPER.teamToTeamDto(team);
        //then
        assertThat(teamDto).isNotNull();
        assertThat(teamDto.getTeamName()).isEqualTo("Los Angeles");
        assertThat(teamDto.getPlayerList().stream().findFirst().orElse(null))
                .extracting(dto -> Tuple.tuple(
                        dto.getPlayerName())
                ).isEqualTo(tuple("Vladimir"));
    }

    @Test
    public void shouldMapperTeamDtoToTeam() {
        //given
        List<PlayerDto> players = Lists.newArrayList(PlayerDto.builder()
                .playerName("Alex")
                .build());
        TeamDto teamDto = TeamDto.builder()
                .teamName("Los Angeles")
                .playerList(players)
                .build();
        //when
        Team team = TeamMapper.MAPPER.toTeam(teamDto);
        //then
        assertThat(team).isNotNull();
        assertThat(team.getTeamName()).isEqualTo("Los Angeles");
        assertThat(team.getPlayerList().stream().findFirst().orElse(null))
                .extracting(player -> Tuple.tuple(
                        player.getPlayerName())
                ).isEqualTo(tuple("Alex"));
    }

    @Test
    public void shouldMapperPlayerDtoToPlayer() {
        //given
        PlayerDto playerDto = PlayerDto.builder()
                .playerName("Nikita")
                .build();
        //when
        Player player = PlayerMapper.MAPPER.toPlayer(playerDto);
        //then
        assertThat(player)
                .isNotNull()
                .extracting(pl -> Tuple.tuple(
                        pl.getPlayerName()
                )).isEqualTo(tuple("Nikita"));
    }

    @Test
    public void shouldMapperPlayerToPlayerDto() {
        //given
        Player player = Player.builder()
                .playerName("Petya")
                .build();
        //when
        PlayerDto playerDto = PlayerMapper.MAPPER.playerToPlayerDto(player);
        //then
        assertThat(playerDto)
                .isNotNull()
                .extracting(pl -> Tuple.tuple(
                        pl.getPlayerName()
                )).isEqualTo(tuple(
                        "Petya"));
    }

}