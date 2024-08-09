package baleksab.logictenacity.api.controllers;

import baleksab.logictenacity.api.dtos.requests.member.AddMemberRequest;
import baleksab.logictenacity.api.dtos.responses.member.MemberResponse;
import baleksab.logictenacity.api.services.interfaces.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody AddMemberRequest request) {
        return memberService.createMember(request);
    }
}
