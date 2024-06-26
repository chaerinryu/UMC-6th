package umc.spring.service.MissionService;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.validation.annotation.MissionChallenged;

import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long missionId);
    Optional<MemberMission> findMemberMission(Long id);
    Optional<MemberMission> findMemberMission(Member member, Mission mission);
}
