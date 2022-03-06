package ru.application.myPractice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.application.myPractice.entity.Team;
import ru.application.myPractice.services.team.TeamService;

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
        Team hello = Team.builder()
                .teamName("Hello")
                .build();
        teamService.save(hello);
        return "home";
    }

    @GetMapping("/index")
    public String pageForAuthenticatedUsers() {
        log.info("GET /index from REST");
        return "index";
    }
}
