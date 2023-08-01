package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.exception.FoodStallNostFoundException;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.FindUserFoodStallByIdService;
import atl.bootcamp.e9.savorspot.util.Mapper;
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
                .findById(id)
                .map(Mapper::mapToUserFoodStallDto)
                .orElseThrow(() -> new FoodStallNostFoundException("Food stall with id " + id + " not found"));
    }
}
