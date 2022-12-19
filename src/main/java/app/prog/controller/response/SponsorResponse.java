package app.prog.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SponsorResponse {
    private int id;
    private String name;
}
