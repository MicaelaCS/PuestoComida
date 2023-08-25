package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GetAllFoodService {

    //getALL in Controller
    List<FoodDTO> getAllFoods();
}
