package app.prog.controller.mapper;

import app.prog.controller.response.CreateTeamResponse;
import app.prog.controller.response.CreateTeamResponse;
import app.prog.controller.response.TeamResponse;
import app.prog.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamRestMapper {

    public TeamResponse toRest(Team domain) {
        return TeamResponse.builder()
                .name(domain.getName())
                .build();
    }

    public Team toDomain(CreateTeamResponse rest) {
        return Team.builder()
                .name(rest.getName())
                .build();
    }

    public Team toDomain(TeamResponse rest) {
        return Team.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }
}
