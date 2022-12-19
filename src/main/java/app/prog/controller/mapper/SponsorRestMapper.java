package app.prog.controller.mapper;

import app.prog.controller.response.CreateSponsorResponse;
import app.prog.controller.response.CreateSponsorResponse;
import app.prog.controller.response.CreateSponsorResponse;
import app.prog.model.Author;
import app.prog.model.Sponsor;
import app.prog.service.SponsorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class SponsorRestMapper {

    private SponsorService sponsorService;
    CreateSponsorResponse toRest(Sponsor domain) {
        CreateSponsorResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .author(domain.getSponsor() != null ? domain.getSponsor().getName() : null)
                .build();
    }

    public Sponsor toDomain(CreateSponsorResponse rest) {
        return Sponsor.builder()
                 .name(rest.getName())
                .build();
    }

    public Sponsor toDomain(CreateSponsorResponse rest) {
        return Sponsor.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }

}
