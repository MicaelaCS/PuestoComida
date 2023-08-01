package atl.bootcamp.e9.savorspot.dto;

public record UserFoodStallDto(
        Long id,
        String fullName,
        String email,
        FoodStallDto foodStallData
) {}
