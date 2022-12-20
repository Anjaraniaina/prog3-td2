package app.prog.service;

import app.prog.model.Team;
import app.prog.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository repository;

    public List<Team> getTeams() {
        return repository.findAll();
    }

    public List<Team> createTeams(List<Team> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Team> updateTeams(List<Team> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Team deleteTeam(int TeamId) {
        Optional<Team> optional = repository.findById(TeamId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", null);
        }
    }
}
