package baleksab.logictenacity.api.mappers;

import baleksab.logictenacity.api.dtos.requests.member.AddMemberRequest;
import baleksab.logictenacity.api.dtos.responses.member.MemberResponse;
import baleksab.logictenacity.api.entities.Member;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MemberMapper {
    Member addMemberToMember(AddMemberRequest request);
    MemberResponse memberToMemberResponse(Member member);
}
