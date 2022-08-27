package ru.application.myPractice.controllers;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.application.myPractice.dto.PlayerDto;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.services.team.TeamService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/my-practice")
public class MainController {

    private final TeamService teamService;

    @Autowired
    public MainController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/home")
    public String homePage() {

        //TODO выпилить строку test
        String test = "1234567890";
        log.info("GET /home from REST {} {}", test, test);

        List<PlayerDto> players = Lists.newArrayList(
                PlayerDto.builder()
                        .playerName("Petya")
                        .build(),
                PlayerDto.builder()
                        .playerName("Ivan")
                        .build());

        TeamDto hello = TeamDto.builder()
                .teamName("Sparta")
                .playerList(players)
                .build();
        teamService.save(hello);

        List<TeamDto> all = teamService.findAll();
        for (TeamDto teamDto : all) {
            List<PlayerDto> playerList = teamDto.getPlayerList();
            playerList.forEach(System.out::println);
        }

        TeamDto teamHello = teamService.findByTeamName("Sparta");

        List<PlayerDto> list = teamHello.getPlayerList();
        System.out.println("--------------");
        list.forEach(System.out::println);
        return "home";
    }
}
