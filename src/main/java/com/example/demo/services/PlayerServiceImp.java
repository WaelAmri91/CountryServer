package com.example.demo.services;

import com.example.demo.Dto.AddPlayerRequest;
import com.example.demo.entities.Player;
import com.example.demo.entities.PlayerPosition;
import com.example.demo.repositories.PlayerRepository;
import com.example.demo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlayerServiceImp implements PlayerService{
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository ;

     @Override
        public List<Player> GetPlayers() {
            return (List<Player>) playerRepository.findAll();
        }

       @Override
       public Player GetPlayer(long PlayerId) {
           return playerRepository.findById(PlayerId).orElse(null);
       }

    @Override
    public Player AddPlayer(AddPlayerRequest request) {
         Player player=new Player();
                player.setTitle(request.getTitle());
                player.setPlayerNumber(request.getPlayerNumber());
               if (Objects.equals(request.getPosition(), "GOALKEEPER")){
                   player.setPosition(PlayerPosition.GOALKEEPER);
            }
        if (Objects.equals(request.getPosition(), "DEFENDER")){
            player.setPosition(PlayerPosition.DEFENDER);
        }
        if (Objects.equals(request.getPosition(), "MIDFIELDER")){
            player.setPosition(PlayerPosition.MIDFIELDER);
        }
        if(request.getTeamId() != null)
            player.setTeam(teamRepository.findById(request.getTeamId()).orElse(null));
        return playerRepository.save(player);
    }

    @Override
    public Player EditPlayer(long PlayerId, AddPlayerRequest request) {
        Player player=playerRepository.findById(PlayerId).orElse(null);
               if(player != null){
                  player.setTitle(request.getTitle());
                   player.setPlayerNumber(request.getPlayerNumber());
                    player.setTeam(teamRepository.findById(request.getTeamId()).orElse(null));
                    if(request.getTeamId() != null)
                        player.setTeam(teamRepository.findById(request.getTeamId()).orElse(null));
                    return playerRepository.save(player);
               }
               return null;
    }

    @Override
    public void DeletePlayer(long PlayerId) {
        playerRepository.deleteById(PlayerId);
    }
}
