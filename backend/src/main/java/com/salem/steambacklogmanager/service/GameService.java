package com.salem.steambacklogmanager.service;

import com.salem.steambacklogmanager.dto.CreateGameRequest;
import com.salem.steambacklogmanager.dto.GameResponse;
import com.salem.steambacklogmanager.dto.UpdateGameRequest;
import com.salem.steambacklogmanager.dto.steam.SteamGame;
import com.salem.steambacklogmanager.exception.GameNotFoundException;
import com.salem.steambacklogmanager.model.Game;
import com.salem.steambacklogmanager.repository.GameRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                game.getStatus(),
                game.getImageUrl()
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
                savedGame.getStatus(),
                savedGame.getImageUrl()
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

    public List<GameResponse> orderByRating(){
        List<Game> games = gameRepository.findAllByOrderByRatingDesc();
        List<GameResponse> responses = new ArrayList<>();
        for (Game game : games) {
            responses.add(toGameResponse(game));
        }
        return responses;
    }

    public Game importSteamGame(SteamGame steamGame) {
        Optional<Game> existingGame =
                gameRepository.findBySteamAppId(steamGame.getAppid());

        Game game;

        if (existingGame.isPresent()) {
            game = existingGame.get();
        } else {
            game = new Game();
            game.setRating(0);
            game.setStatus("Backlog");
        }

        game.setTitle(steamGame.getName());
        game.setHoursPlayed(steamGame.getPlaytime_forever() / 60);
        game.setSteamAppId(steamGame.getAppid());

        String imageUrl =
                "https://steamcdn-a.akamaihd.net/steam/apps/"
                        + steamGame.getAppid()
                        + "/library_600x900.jpg";

        game.setImageUrl(imageUrl);

        return gameRepository.save(game);
    }

    public List<GameResponse> importSteamGames(List<SteamGame> steamGames) {
        List<GameResponse> responses = new ArrayList<>();
        for (SteamGame game : steamGames) {
            Game newGame = importSteamGame(game);
            responses.add(toGameResponse(newGame));
        }
        return responses;
    }

    public GameResponse getGameById(Long id) {
        Optional<Game> existingGame = gameRepository.findById(id);

        if (existingGame.isPresent()) {
            return toGameResponse(existingGame.get());
        }

        return null;
    }
}
