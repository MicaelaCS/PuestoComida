package atl.bootcamp.e9.savorspot.util;

import atl.bootcamp.e9.savorspot.dto.FoodStallDto;
import atl.bootcamp.e9.savorspot.dto.RegisterUserFoodStallDto;
import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.model.FoodStall;
import atl.bootcamp.e9.savorspot.model.UserStatus;

public final class UserMapper {

    private UserMapper() {
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

    public static UserFoodStallDto mapToUserFoodStallDto(FoodStall foodStall) {
        return new UserFoodStallDto(
                foodStall.getId(),
                foodStall.getFullName(),
                foodStall.getEmail(),
                foodStall.getUserStatus(),
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

    public static FoodStall mapToFoodStallToRegister(RegisterUserFoodStallDto registerUserFoodStallDto) {
        FoodStall foodStall = new FoodStall();
        foodStall.setFullName(registerUserFoodStallDto.fullName());
        foodStall.setEmail(registerUserFoodStallDto.email());
        foodStall.setPassword(registerUserFoodStallDto.password());
        foodStall.setUserStatus(UserStatus.ACTIVE);
        foodStall.setFoodStallName(registerUserFoodStallDto.foodStallName());
        foodStall.setAddress(registerUserFoodStallDto.address());
        foodStall.setTypeCuisine(registerUserFoodStallDto.typeCuisine());
        foodStall.setAttentionSchedules(registerUserFoodStallDto.attentionSchedules());
        foodStall.setPhone(registerUserFoodStallDto.phone());
        foodStall.setFacadeImageUrl(registerUserFoodStallDto.facadeImageUrl());
        foodStall.setLatitude(registerUserFoodStallDto.latitude());
        foodStall.setLongitude(registerUserFoodStallDto.longitude());
        return foodStall;
    }

    public static FoodStall mapToFoodStallToUpdate(UserFoodStallDto userFoodStallDto, FoodStall foodStall) {
        if(userFoodStallDto.fullName() != null) foodStall.setFullName(userFoodStallDto.fullName());
        if(userFoodStallDto.email() != null) foodStall.setEmail(userFoodStallDto.email());
        if(userFoodStallDto.foodStallName() != null) foodStall.setFoodStallName(userFoodStallDto.foodStallName());
        if(userFoodStallDto.address() != null) foodStall.setAddress(userFoodStallDto.address());
        if(userFoodStallDto.typeCuisine() != null) foodStall.setTypeCuisine(userFoodStallDto.typeCuisine());
        if(userFoodStallDto.attentionSchedules() != null) foodStall.setAttentionSchedules(userFoodStallDto.attentionSchedules());
        if(userFoodStallDto.phone() != null) foodStall.setPhone(userFoodStallDto.phone());
        if(userFoodStallDto.facadeImageUrl() != null) foodStall.setFacadeImageUrl(userFoodStallDto.facadeImageUrl());
        if(userFoodStallDto.latitude() != null) foodStall.setLatitude(userFoodStallDto.latitude());
        if(userFoodStallDto.longitude() != null) foodStall.setLongitude(userFoodStallDto.longitude());
        return foodStall;
    }
}
