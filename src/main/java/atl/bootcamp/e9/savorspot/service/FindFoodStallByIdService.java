package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.dto.FoodStallDto;

public interface FindFoodStallByIdService {
    FoodStallDto findWith(Long id);
}
