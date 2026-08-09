package com.salem.steambacklogmanager.controller;


import com.salem.steambacklogmanager.dto.CreateGameRequest;
import com.salem.steambacklogmanager.dto.GameResponse;
import com.salem.steambacklogmanager.dto.UpdateGameRequest;
import com.salem.steambacklogmanager.model.Game;
import com.salem.steambacklogmanager.service.GameService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
    public GameResponse updateGame(
            @PathVariable Long id,
            @Valid @RequestBody UpdateGameRequest request) {
        return gameService.updateGame(id, request);
    }

    @GetMapping("/search")
    public List<GameResponse> searchGames(@RequestParam String title) {
        return gameService.searchGames(title);
    }

    @GetMapping("/status")
    public List<GameResponse> searchGamesByStatus(@RequestParam String status) {
        return gameService.filterByStatus(status);
    }

    @GetMapping("/rating")
    public List<GameResponse> orderByRating() {
        return gameService.orderByRating();
    }


}
