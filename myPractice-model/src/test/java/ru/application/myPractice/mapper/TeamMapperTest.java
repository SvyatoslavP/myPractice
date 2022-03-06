package ru.application.myPractice.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.entity.Team;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TeamMapperTest {

    @Test
    public void shouldTeamToTeamDto() {
        //given
        Team team = Team.builder()
                .teamName("Los Angeles")
                .build();
        //when
        TeamDto teamDto = TeamMapper.INSTANCE.teamToTeamDto(team);
        //then
        assertThat(teamDto).isNotNull();
        assertThat(teamDto.getPersistenceId()).isNotNull();
        assertThat(teamDto.getTeamName()).isEqualTo("Los Angeles");
    }
}