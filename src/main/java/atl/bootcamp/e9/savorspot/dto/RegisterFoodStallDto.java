package atl.bootcamp.e9.savorspot.dto;

public record RegisterFoodStallDto(
        String fullName,
        String email,
        String password,
        String foodStallName,
        String address,
        String typeCuisine,
        String attentionSchedules,
        String phone,
        String facadeImageUrl,
        Double latitude,
        Double longitude
) {}
