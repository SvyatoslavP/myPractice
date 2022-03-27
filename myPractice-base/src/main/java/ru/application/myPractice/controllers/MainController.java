package ru.application.myPractice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.application.myPractice.dto.PlayerDto;
import ru.application.myPractice.dto.TeamDto;
import ru.application.myPractice.services.team.TeamService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
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

        Set<PlayerDto> players = new HashSet<>(List.of(
                PlayerDto.builder()
                        .age(18)
                        .name("Petya")
                        .surname("Petrov")
                        .build(),
                PlayerDto.builder()
                        .age(22)
                        .name("Ivan")
                        .surname("Ivanov")
                        .build()
        ));

        TeamDto hello = TeamDto.builder()
                .teamName("Hello")
                .playerSet(players)
                .build();
        teamService.save(hello);

        List<TeamDto> all = teamService.findAll();
        for (TeamDto teamDto : all) {
            Set<PlayerDto> set = teamDto.getPlayerSet();
            set.forEach(System.out::println);
        }

        return "home";
    }

    @GetMapping("/index")
    public String pageForAuthenticatedUsers() {
        log.info("GET /index from REST");
        return "index";
    }
}
