package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

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
}
