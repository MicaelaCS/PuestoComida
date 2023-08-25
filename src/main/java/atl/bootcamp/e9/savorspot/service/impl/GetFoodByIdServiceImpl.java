package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import atl.bootcamp.e9.savorspot.model.Foods;
import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import atl.bootcamp.e9.savorspot.service.GetFoodByIdService;
import org.springframework.stereotype.Service;

@Service
public class GetFoodByIdServiceImpl implements GetFoodByIdService {

    private final FoodsRepository foodsRepository;

    public GetFoodByIdServiceImpl(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }

    @Override
    public FoodDTO getFoodById(long id) {

        Foods foods = foodsRepository.findById(id).orElseThrow();
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setName(foods.getName());
        foodDTO.setPrice(foods.getPrice());
        foodDTO.setDescription(foods.getDescription());
        return foodDTO;
    }
}
