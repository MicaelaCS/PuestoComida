package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface GetFoodByIdService {
    //getById in Controller
    FoodDTO getFoodById(long id);
}
