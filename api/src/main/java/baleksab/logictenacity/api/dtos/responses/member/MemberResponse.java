package baleksab.logictenacity.api.dtos.responses.member;

import lombok.Data;

@Data
public class MemberResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
