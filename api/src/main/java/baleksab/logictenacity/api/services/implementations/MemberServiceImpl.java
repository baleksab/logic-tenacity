package baleksab.logictenacity.api.services.implementations;

import baleksab.logictenacity.api.dtos.requests.member.AddMemberRequest;
import baleksab.logictenacity.api.dtos.responses.member.MemberResponse;
import baleksab.logictenacity.api.mappers.MemberMapper;
import baleksab.logictenacity.api.repositories.MemberRepository;
import baleksab.logictenacity.api.services.interfaces.MemberService;
import baleksab.logictenacity.api.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(
            MemberMapper memberMapper,
            PasswordEncoder passwordEncoder,
            MemberRepository memberRepository
    ) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }

    @Override
    public ResponseEntity<MemberResponse> createMember(AddMemberRequest request) {
        var member = memberMapper.addMemberToMember(request);
        var password = passwordEncoder.encode(PasswordGenerator.generateRandomPassword((8)));

        member.setPassword(password);
        memberRepository.save(member);

        var memberResponse = memberMapper.memberToMemberResponse(member);

        return new ResponseEntity<>(memberResponse, HttpStatus.CREATED);
    }
}
