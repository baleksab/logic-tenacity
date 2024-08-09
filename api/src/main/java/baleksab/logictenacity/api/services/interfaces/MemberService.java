package baleksab.logictenacity.api.services.interfaces;

import baleksab.logictenacity.api.dtos.requests.member.AddMemberRequest;
import baleksab.logictenacity.api.dtos.responses.member.MemberResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity<MemberResponse> createMember(AddMemberRequest request);
}
