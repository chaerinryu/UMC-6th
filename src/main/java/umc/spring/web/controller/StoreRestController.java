package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    // 특정 지역에 가게 추가하는 api
    @PostMapping("/add")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.StoreDTO request) {
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }

    // 가게에 리뷰 추가하는 api
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    // 가게에 미션 추가하는 api
    @PostMapping("/{storeId}/mission")
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> createMission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                                              @ExistStore @PathVariable(name = "storeId") Long storeId) {
        Mission mission = storeCommandService.createMisson(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateMissionResultDTO(mission));
    }
}