package app.prog.controller.mapper;

import app.prog.controller.response.CreateTeamResponse;
import app.prog.controller.response.CreateTeamResponse;
import app.prog.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamRestMapper {

    CreateTeamResponse toRest(Team domain) {
        CreateTeamResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public Team toDomain(CreateTeamResponse rest) {
        return Team.builder()
                .name(rest.getName())
                .build();
    }
}
