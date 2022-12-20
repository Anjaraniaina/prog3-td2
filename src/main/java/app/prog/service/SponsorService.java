package app.prog.service;

import app.prog.model.Sponsor;
import app.prog.repository.SponsorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SponsorService {
    private final SponsorRepository repository;

    public List<Sponsor> getSponsors() {
        return repository.findAll();
    }


    public List<Sponsor> createSponsors(List<Sponsor> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Sponsor> updateSponsors(List<Sponsor> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Sponsor deleteSponsor(int sponsorId) {
        Optional<Sponsor> optional = repository.findById(sponsorId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", null);
        }
    }

    public Sponsor findById(int sponsorId) {
        return repository.getById(sponsorId);
    }
}
