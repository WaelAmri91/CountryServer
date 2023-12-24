package com.example.demo.services;

import com.example.demo.entities.Team;

import java.util.List;

public interface TeamService {
    List<Team> GetTeams();
    Team addTeam(Team request);
}
