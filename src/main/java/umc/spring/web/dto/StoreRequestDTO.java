package umc.spring.web.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StoreRequestDTO {

    @Getter
    public static class StoreDTO{
        @NotBlank
        String region;
        @NotBlank
        String name;
        @NotBlank
        String address;
    }

    @Getter
    public static class ReveiwDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;

        MultipartFile reviewImage;
    }

    @Getter
    public static class MissionDTO{
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }
}
