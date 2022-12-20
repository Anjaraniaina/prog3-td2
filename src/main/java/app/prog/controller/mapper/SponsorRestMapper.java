package app.prog.controller.mapper;

import app.prog.controller.response.CreateSponsorResponse;
import app.prog.controller.response.SponsorResponse;
import app.prog.model.Sponsor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SponsorRestMapper {


    public SponsorResponse toRest(Sponsor domain) {
        return SponsorResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public Sponsor toDomain(CreateSponsorResponse rest) {
        return Sponsor.builder()
                .name(rest.getName())
                .build();
    }

    public Sponsor toDomain(SponsorResponse rest) {
        return Sponsor.builder()
                .name(rest.getName())
                .build();
    }
}
