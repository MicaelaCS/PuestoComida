package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import atl.bootcamp.e9.savorspot.model.Foods;
import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import atl.bootcamp.e9.savorspot.service.GetAllFoodService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllFoodServiceImpl implements GetAllFoodService {

    private final FoodsRepository foodsRepository;

    public GetAllFoodServiceImpl(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }
    @Override
    public List<FoodDTO> getAllFoods() {

        List<Foods> all = foodsRepository.findAll();
        List<FoodDTO> food = new ArrayList<>();

        for (Foods foods : all){
            FoodDTO foodDto = new FoodDTO();
            foodDto.setName(foods.getName());
            foodDto.setPrice(foods.getPrice());
            foodDto.setDescription(foods.getDescription());
            food.add(foodDto);
        }
        return food ;
    }
}
