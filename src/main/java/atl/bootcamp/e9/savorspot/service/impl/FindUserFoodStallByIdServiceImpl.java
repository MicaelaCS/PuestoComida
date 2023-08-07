package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.exception.FoodStallNotFoundException;
import atl.bootcamp.e9.savorspot.model.UserStatus;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.FindUserFoodStallByIdService;
import atl.bootcamp.e9.savorspot.util.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class FindUserFoodStallByIdServiceImpl implements FindUserFoodStallByIdService {

    private final FoodStallRepository foodStallRepository;

    public FindUserFoodStallByIdServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public UserFoodStallDto findWith(Long id) {
        return foodStallRepository
                .findByIdAndUserStatusNot(id, UserStatus.INACTIVE)
                .map(UserMapper::mapToUserFoodStallDto)
                .orElseThrow(() -> new FoodStallNotFoundException("Food stall with id " + id + " not found"));
    }
}
