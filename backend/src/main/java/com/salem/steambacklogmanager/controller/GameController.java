package com.salem.steambacklogmanager.controller;


import com.salem.steambacklogmanager.model.Game;
import com.salem.steambacklogmanager.service.GameService;
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
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
