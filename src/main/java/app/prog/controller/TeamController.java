package app.prog.controller;

import app.prog.controller.mapper.TeamRestMapper;
import app.prog.controller.response.TeamResponse;
import app.prog.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService service;
    private final TeamRestMapper mapper;

    @GetMapping("/teams")
    public List<TeamResponse> getTeams() {
        List<TeamResponse> list = new ArrayList<>();
        for (Team category : service.getCategories()) {
            TeamResponse TeamResponse = mapper.toRest(category);
            list.add(app.prog.controller.response.TeamResponse);
        }
        return list;
    }



    @PostMapping("/teams")
    public List<TeamResponse> createCategories(@RequestBody List<TeamResponse> toCreate) {
        List<Team> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createCategories(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/teams/{teamId}")
    public TeamResponse deleteTeam(@PathVariable Integer teamId) {
        return mapper.toRest(service.deleteTeam(teamId));
    }
}
