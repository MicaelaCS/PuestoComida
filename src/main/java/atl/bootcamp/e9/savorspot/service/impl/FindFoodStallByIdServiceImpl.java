package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.FoodStallDto;
import atl.bootcamp.e9.savorspot.exception.FoodStallNotFoundException;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.FindFoodStallByIdService;
import atl.bootcamp.e9.savorspot.util.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class FindFoodStallByIdServiceImpl implements FindFoodStallByIdService {

    private final FoodStallRepository foodStallRepository;

    public FindFoodStallByIdServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public FoodStallDto findWith(Long id) {
        return foodStallRepository
                .findById(id)
                .map(UserMapper::mapToFoodStallDto)
                .orElseThrow(() -> new FoodStallNotFoundException("Food stall with id " + id + " not found"));
    }
}
