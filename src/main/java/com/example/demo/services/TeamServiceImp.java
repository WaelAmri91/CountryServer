package com.example.demo.services;

import com.example.demo.entities.Team;
import com.example.demo.repositories.TeamRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceImp implements TeamService{
    @Autowired
    TeamRepository teamRepository ;

    @Override
    public List<Team> GetTeams(){ return (List<Team>) teamRepository.findAll();}

    @Override
    public  Team addTeam(Team request){
        Team team= new Team(request.getTitle());

        return teamRepository.save(team);
    }



}
