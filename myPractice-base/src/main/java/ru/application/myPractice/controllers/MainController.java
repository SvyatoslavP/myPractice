package ru.application.myPractice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String homePage(Model model) {

        //TODO выпилить строку test
        String test = "1234567890";
        log.info("GET /home from REST {} {}", test, test);
        List<TeamDto> teamList = teamService.findAll();
        model.addAttribute("teamList", teamList);
        model.addAttribute("team", teamList.get(0));
        return "home";
    }
}
