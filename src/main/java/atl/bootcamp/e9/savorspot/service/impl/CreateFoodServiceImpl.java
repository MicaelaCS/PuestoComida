package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import atl.bootcamp.e9.savorspot.model.Foods;
import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import atl.bootcamp.e9.savorspot.service.CreateFoodService;
import org.springframework.stereotype.Service;

@Service
public class CreateFoodServiceImpl implements CreateFoodService {

    private final FoodsRepository foodsRepository;

    public CreateFoodServiceImpl(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }

    @Override
    public FoodDTO createFood(FoodDTO foodDto) {
        Foods foods = new Foods();
        foods.setName(foodDto.getName());
        foods.setPrice(foodDto.getPrice());
        foods.setDescription(foodDto.getDescription());
        foodsRepository.save(foods);

        return foodDto;
    }
}
