package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.RegisterFoodStallDto;
import atl.bootcamp.e9.savorspot.model.FoodStall;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.RegisterFoodService;
import org.springframework.stereotype.Service;

@Service
public class RegisterFoodStallServiceImpl implements RegisterFoodService {

    private final FoodStallRepository foodStallRepository;

    public RegisterFoodStallServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public void create(RegisterFoodStallDto registerNewFoodStallDto) {

        foodStallRepository.save(mapToEntity(registerNewFoodStallDto));

    }

    private FoodStall mapToEntity(RegisterFoodStallDto registerFoodStallDto) {
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
}
