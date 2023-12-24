package com.example.demo.controllers;


import com.example.demo.Dto.AddPlayerRequest;
import com.example.demo.entities.Player;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/GetPlayers")
        public List<Player> GetPlayers(){
           return playerService.GetPlayers();
    }

        @GetMapping("/GetPlayer/{idPlayer}")
        public Player GetPlayer(@PathVariable("idPlayer") Long idPlayer ){
           return playerService.GetPlayer(idPlayer);
       }

        @PostMapping("/AddPlayer")
       public Player AddPlayer(@RequestBody AddPlayerRequest request){
            return playerService.AddPlayer(request);
       }

        @PutMapping("/EditPlayer/{idPlayer}")
        public Player EditCountry(@PathVariable("idPlayer") Long idCountry,@RequestBody AddPlayerRequest request ){
           return playerService.EditPlayer(idCountry,request);
        }

        @DeleteMapping("/DeletePlayer/{idPlayer}")
        public void DeletePlayer(@PathVariable("idPlayer") Long idPlayer ){
             playerService.DeletePlayer(idPlayer);
        }
}
