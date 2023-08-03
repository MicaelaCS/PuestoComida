package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.exception.FoodStallNotFoundException;
import atl.bootcamp.e9.savorspot.model.FoodStall;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.UpdateFoodStallService;
import atl.bootcamp.e9.savorspot.util.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateFoodStallServiceImpl implements UpdateFoodStallService {

    private final FoodStallRepository foodStallRepository;

    public UpdateFoodStallServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public void update(UserFoodStallDto userFoodStallDto) {

        FoodStall foodStall = foodStallRepository
                .findById(userFoodStallDto.id())
                .orElseThrow(() -> new FoodStallNotFoundException("Food stall with id " + userFoodStallDto.id() + " not found"));

        foodStallRepository.save(UserMapper.mapToFoodStallForUpdate(userFoodStallDto, foodStall));
    }
}
