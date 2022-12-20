package app.prog.controller.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeamResponse {
    private int id;
    private String name;
    private List<CreatePlayerResponse> players;
    private List<CreateSponsorResponse> sponsors;
}
