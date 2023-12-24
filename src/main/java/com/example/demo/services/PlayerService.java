package com.example.demo.services;

import com.example.demo.Dto.AddCountryRequest;
import com.example.demo.Dto.AddPlayerRequest;
import com.example.demo.entities.Country;
import com.example.demo.entities.Player;

import java.util.List;

public interface PlayerService {
    List<Player> GetPlayers();

    Player GetPlayer(long PlayerId);

    Player AddPlayer(AddPlayerRequest request);

    Player EditPlayer(long PlayerId ,AddPlayerRequest request);

    void DeletePlayer(long PlayerId);
}
