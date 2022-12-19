package app.prog.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamResponse {
    private int id;
    private String name;
}
