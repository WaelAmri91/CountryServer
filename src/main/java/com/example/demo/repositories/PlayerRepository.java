package com.example.demo.repositories;

import com.example.demo.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
}
