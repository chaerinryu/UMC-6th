package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.MissionChallenged;

import javax.validation.constraints.NotNull;

public class MissionRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
