package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.MissionChallenged;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    // 미션 도전하기 api
    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDTO.CreateMemberMissionResultDTO> challengingMission(
            @RequestBody @Valid @MissionChallenged(memberIdField = "memberId", missionIdField = "missionId")
            MissionRequestDTO.ChallengeMissionDTO request) {
        MemberMission memberMission = missionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMemberMissionDTO(memberMission));
    }
}
