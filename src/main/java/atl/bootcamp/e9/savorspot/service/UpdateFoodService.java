package atl.bootcamp.e9.savorspot.service;


import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpdateFoodService {
    //update in Controller
    FoodDTO updateFood(FoodDTO Food, long id);
}
