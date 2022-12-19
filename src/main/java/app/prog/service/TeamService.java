package app.prog.service;

import app.prog.model.Team;
import app.prog.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository repository;

    public List<Team> getCategories() {
        return repository.findAll();
    }

    public List<Team> createCategories(List<Team> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Team> updateCategories(List<Team> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Team deleteTeam(Integer TeamId) {
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
