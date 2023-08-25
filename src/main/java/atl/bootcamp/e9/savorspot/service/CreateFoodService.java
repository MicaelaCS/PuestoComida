package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateFoodService {
    //POST in Controller
    FoodDTO createFood(FoodDTO foodDto);
}
