package app.prog.controller;

import app.prog.controller.mapper.SponsorRestMapper;
import app.prog.controller.response.SponsorResponse;
import app.prog.controller.response.CreateSponsorResponse;
import app.prog.controller.response.UpdateSponsorResponse;
import app.prog.model.Sponsor;
import app.prog.service.SponsorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class SponsorController {
    private final SponsorService service;
    private final SponsorRestMapper mapper;

    @GetMapping("/books")
    public List<SponsorResponse> getSponsors() {
        List<SponsorResponse> list = new ArrayList<>();
        for (Sponsor sponsor : service.getSponsors()) {
            SponsorResponse sponsorResponse = mapper.toRest(sponsor);
            list.add(sponsorResponse);
        }
        return list;
    }

    @PostMapping("/books")
    public List<SponsorResponse> createSponsors(@RequestBody List<CreateSponsorResponse> toCreate) {
        List<Sponsor> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createSponsors(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/books")
    public List<SponsorResponse> updateSponsors(@RequestBody List<UpdateSponsorResponse> toUpdate) {
        List<Sponsor> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateSponsors(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/books/{sponsorId}")
    public ResponseEntity<?> deleteSponsor(@PathVariable int sponsorId) {
        Sponsor book = service.findById(sponsorId);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Content-Type", "text/plain")
                    .body("Sponsor with id" + sponsorId + "is not found");
        }
        service.deleteSponsor(sponsorId);
        return ResponseEntity.ok().build();
    }
}

