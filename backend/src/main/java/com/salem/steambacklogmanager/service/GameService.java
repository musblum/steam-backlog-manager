package com.salem.steambacklogmanager.service;

import com.salem.steambacklogmanager.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    public List<Game> getGames() {

    List<Game> games = new ArrayList<>();

        games.add(new Game(
                "Elden Ring",
                10,
                300,
                "Completed"
        ));
        games.add(new Game(
                "Cyberpunk 2077",
                9,
                120,
                "Completed"
        ));
        games.add(new Game(
                "Baldur's Gate 3",
                10,
                180,
                "Completed"
        ));

        return games;

    }
}
