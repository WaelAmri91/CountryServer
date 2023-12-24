package com.example.demo.controllers;


import com.example.demo.entities.Team;
import com.example.demo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/getTeam")
    public List<Team> GetTeams(){
        return teamService.GetTeams();}

    @PostMapping("/addTeam")
    public Team addTeam(@RequestBody Team team){
        return teamService.addTeam(team);
    }
}
