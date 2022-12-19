package app.prog.controller.mapper;

import app.prog.controller.response.PlayerResponse;
import app.prog.controller.response.CreatePlayerResponse;
import app.prog.controller.response.UpdatePlayerResponse;
import app.prog.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerRestMapper {
    public PlayerResponse toRest(Player domain) {
        return PlayerResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public Player toDomain(CreatePlayerResponse rest) {
        return Player.builder()
                .name(rest.getName())
                .build();
    }

    public Player toDomain(UpdatePlayerResponse rest) {
        return Player.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }
}
