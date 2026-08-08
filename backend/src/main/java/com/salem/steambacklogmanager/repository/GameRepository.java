package com.salem.steambacklogmanager.repository;

import com.salem.steambacklogmanager.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByTitleContainingIgnoreCase(String title);

    List<Game> findByStatusIgnoreCase(String status);

    List<Game> findAllByOrderByRatingDesc();
}
