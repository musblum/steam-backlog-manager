package com.salem.steambacklogmanager.controller;


import com.salem.steambacklogmanager.dto.CreateGameRequest;
import com.salem.steambacklogmanager.dto.GameResponse;
import com.salem.steambacklogmanager.model.Game;
import com.salem.steambacklogmanager.service.GameService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
       this.gameService = gameService;
    }

    @GetMapping
    public List<GameResponse> getGames() {
        return gameService.getGames();
    }

    @PostMapping
    public GameResponse createGame(@Valid @RequestBody CreateGameRequest request) {
        return gameService.createGame(request);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }

    @PutMapping("/{id}")
    public Game updateGame(
            @PathVariable Long id,
            @Valid @RequestBody Game updatedGame) {
        return gameService.updateGame(id, updatedGame);
    }
}
