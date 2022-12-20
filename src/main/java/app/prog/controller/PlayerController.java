package app.prog.controller;

import app.prog.controller.mapper.PlayerRestMapper;
import app.prog.controller.response.PlayerResponse;
import app.prog.controller.response.CreatePlayerResponse;
import app.prog.model.Player;
import app.prog.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {
    private PlayerService service;
    private final PlayerRestMapper mapper;

    @GetMapping("/players")
    public List<PlayerResponse> getPlayers() {
        List<PlayerResponse> list = new ArrayList<>();
        for (Player author : service.getPlayers()) {
            PlayerResponse authorResponse = mapper.toRest(author);
            list.add(authorResponse);
        }
        return list;
    }

    @PostMapping("/players")
    public List<PlayerResponse> createPlayers(@RequestBody List<CreatePlayerResponse> toCreate) {
        List<Player> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createPlayers(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/players")
    public List<PlayerResponse> updatePlayers(@RequestBody List<PlayerResponse> toUpdate) {
        List<Player> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updatePlayers(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/players/{playerId}")
    public PlayerResponse deletePlayer(@PathVariable Integer playerId) {
        return mapper.toRest(service.deletePlayer(playerId));
    }
}
