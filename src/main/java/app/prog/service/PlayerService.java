package app.prog.service;

import app.prog.model.Player;
import app.prog.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public List<Player> getPlayers() {
        return repository.findAll();
    }

    // TODO: Make Case insensitive through REGEX
    public List<Player> findByName(String name) {
        return repository.findAll()
                .stream()
                .filter(author -> Objects.equals(author.getName(), name)).toList();
    }


    public List<Player> createPlayers(List<Player> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Player> updatePlayers(List<Player> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Player deletePlayer(Integer playerId) {
        Optional<Player> optional = repository.findById(playerId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", null);
        }
    }
}
