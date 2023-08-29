package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import atl.bootcamp.e9.savorspot.model.Foods;
import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import atl.bootcamp.e9.savorspot.service.UpdateFoodService;
import org.springframework.stereotype.Service;

@Service
public class UpdateFoodServiceImpl implements UpdateFoodService {
    private final FoodsRepository foodsRepository;

    public UpdateFoodServiceImpl(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }
    @Override
    public FoodDTO updateFood (FoodDTO foodDTO, long id) {

        Foods existingFoods = foodsRepository.findById(id).orElseThrow();
        //updating existing Foods
        existingFoods.setName(foodDTO.getName());
        existingFoods.setPrice(foodDTO.getPrice());
        existingFoods.setDescription(foodDTO.getDescription());
        //saving existing Foods

        foodsRepository.save(existingFoods);
        return foodDTO;

    }
}
