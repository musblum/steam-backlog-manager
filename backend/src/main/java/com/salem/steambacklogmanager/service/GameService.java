package com.salem.steambacklogmanager.service;

import com.salem.steambacklogmanager.dto.CreateGameRequest;
import com.salem.steambacklogmanager.dto.GameResponse;
import com.salem.steambacklogmanager.dto.UpdateGameRequest;
import com.salem.steambacklogmanager.exception.GameNotFoundException;
import com.salem.steambacklogmanager.model.Game;
import com.salem.steambacklogmanager.repository.GameRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameResponse> getGames() {
        List<Game> games =  gameRepository.findAll();
        List<GameResponse> responses = new ArrayList<>();

        for (Game game : games) {
            responses.add(toGameResponse(game));
        }
        return responses;
    }

    private GameResponse toGameResponse(Game game) {
        return new GameResponse(
                game.getId(),
                game.getTitle(),
                game.getRating(),
                game.getHoursPlayed(),
                game.getStatus()
        );
    }

    public GameResponse createGame(CreateGameRequest request) {
        Game game = new Game(
                request.getTitle(),
                request.getRating(),
                request.getHoursPlayed(),
                request.getStatus()
        );
        Game savedGame =  gameRepository.save(game);
        return new GameResponse(
                savedGame.getId(),
                savedGame.getTitle(),
                savedGame.getRating(),
                savedGame.getHoursPlayed(),
                savedGame.getStatus()
        );
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public GameResponse updateGame(Long id, UpdateGameRequest request ) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));

        existingGame.setTitle(request.getTitle());
        existingGame.setRating(request.getRating());
        existingGame.setHoursPlayed(request.getHoursPlayed());
        existingGame.setStatus(request.getStatus());

        Game savedGame =  gameRepository.save(existingGame);
        return toGameResponse(savedGame);
    }

    public List<GameResponse> searchGames(String title) {
        List<Game> games =  gameRepository.findByTitleContainingIgnoreCase(title);
        List<GameResponse> responses = new ArrayList<>();
        for (Game game : games) {
            responses.add(toGameResponse(game));
        }
        return responses;
    }

    public List<GameResponse> filterByStatus(String status) {
        List<Game> games = gameRepository.findByStatusIgnoreCase(status);
        List<GameResponse> responses = new ArrayList<>();
        for (Game game : games) {
            responses.add(toGameResponse(game));
        }
        return responses;
    }
}
