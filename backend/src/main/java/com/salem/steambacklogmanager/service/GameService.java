package com.salem.steambacklogmanager.service;

import com.salem.steambacklogmanager.model.Game;
import com.salem.steambacklogmanager.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return gameRepository.findAll();

    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public Game updateGame(Long id, Game updatedGame ) {

        Game existingGame = gameRepository.findById(id)
                .orElseThrow();

        existingGame.setTitle(updatedGame.getTitle());
        existingGame.setRating(updatedGame.getRating());
        existingGame.setHoursPlayed(updatedGame.getHoursPlayed());
        existingGame.setStatus(updatedGame.getStatus());

        return gameRepository.save(existingGame);
    }
}
