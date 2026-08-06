package com.salem.steambacklogmanager.repository;

import com.salem.steambacklogmanager.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
