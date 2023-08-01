package atl.bootcamp.e9.savorspot.util;

import atl.bootcamp.e9.savorspot.dto.FoodStallDto;
import atl.bootcamp.e9.savorspot.dto.RegisterFoodStallDto;
import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.model.FoodStall;

public final class Mapper {

    private Mapper() {
        throw new UnsupportedOperationException("A static class cannot be instantiated");
    }

    public static FoodStallDto mapToFoodStallDto(FoodStall foodStall) {
        return new FoodStallDto(
                foodStall.getId(),
                foodStall.getFoodStallName(),
                foodStall.getAddress(),
                foodStall.getTypeCuisine(),
                foodStall.getAttentionSchedules(),
                foodStall.getPhone(),
                foodStall.getFacadeImageUrl(),
                foodStall.getLatitude(),
                foodStall.getLongitude()
        );
    }

    public static FoodStall mapToFoodStall(RegisterFoodStallDto registerFoodStallDto) {
        FoodStall foodStall = new FoodStall();
        foodStall.setFullName(registerFoodStallDto.fullName());
        foodStall.setEmail(registerFoodStallDto.email());
        foodStall.setPassword(registerFoodStallDto.password());
        foodStall.setFoodStallName(registerFoodStallDto.foodStallName());
        foodStall.setAddress(registerFoodStallDto.address());
        foodStall.setTypeCuisine(registerFoodStallDto.typeCuisine());
        foodStall.setAttentionSchedules(registerFoodStallDto.attentionSchedules());
        foodStall.setPhone(registerFoodStallDto.phone());
        foodStall.setFacadeImageUrl(registerFoodStallDto.facadeImageUrl());
        foodStall.setLatitude(registerFoodStallDto.latitude());
        foodStall.setLongitude(registerFoodStallDto.longitude());
        return foodStall;
    }

    public static UserFoodStallDto mapToUserFoodStallDto(FoodStall foodStall) {
        return new UserFoodStallDto(
                foodStall.getId(),
                foodStall.getFullName(),
                foodStall.getEmail(),
                new FoodStallDto(
                        foodStall.getId(),
                        foodStall.getFoodStallName(),
                        foodStall.getAddress(),
                        foodStall.getTypeCuisine(),
                        foodStall.getAttentionSchedules(),
                        foodStall.getPhone(),
                        foodStall.getFacadeImageUrl(),
                        foodStall.getLatitude(),
                        foodStall.getLongitude()
                )
        );
    }

}
