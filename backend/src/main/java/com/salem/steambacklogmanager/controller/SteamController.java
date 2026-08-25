package com.salem.steambacklogmanager.controller;

import com.salem.steambacklogmanager.dto.GameResponse;
import com.salem.steambacklogmanager.dto.steam.SteamGame;
import com.salem.steambacklogmanager.dto.steam.SteamOwnedGameResponse;
import com.salem.steambacklogmanager.service.GameService;
import com.salem.steambacklogmanager.service.SteamService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/steam")
public class SteamController {

    private final SteamService steamService;
    private final GameService gameService;

    public SteamController(SteamService steamService, GameService gameService) {
        this.steamService = steamService;
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public SteamOwnedGameResponse getOwnedGames(@RequestParam String steamId) {
        return steamService.getOwnedGames(steamId);
    }

    @PostMapping("/import")
    public List<GameResponse> importSteamGames(@RequestParam String steamId) {
        SteamOwnedGameResponse ownedGames = steamService.getOwnedGames(steamId);
        List<SteamGame> steamGames = ownedGames.getResponse().getGames();

        List<Long> appIds = new ArrayList<>();
        for (SteamGame steamGame : steamGames) {
            appIds.add(steamGame.getAppid());
        }

        Map<Long, String> imageUrls =
                steamService.getLibraryCapsuleUrls(appIds);
        System.out.println("SKATE URL: " + imageUrls.get(3354750L));

        List<GameResponse> importedGames = gameService.importSteamGames(steamGames, imageUrls);
        return importedGames;
    }

}
