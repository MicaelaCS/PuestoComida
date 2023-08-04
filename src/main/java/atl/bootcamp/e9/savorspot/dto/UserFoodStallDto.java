package atl.bootcamp.e9.savorspot.dto;

import atl.bootcamp.e9.savorspot.model.UserStatus;

public record UserFoodStallDto(
        Long id,
        String fullName,
        String email,
        UserStatus status,
        String foodStallName,
        String address,
        String typeCuisine,
        String attentionSchedules,
        String phone,
        String facadeImageUrl,
        Double latitude,
        Double longitude
) {}
