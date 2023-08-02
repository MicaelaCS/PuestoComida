package atl.bootcamp.e9.savorspot.dto;

public record UserFoodStallDto(
        Long id,
        String fullName,
        String email,
        String foodStallName,
        String address,
        String typeCuisine,
        String attentionSchedules,
        String phone,
        String facadeImageUrl,
        Double latitude,
        Double longitude
) {}
