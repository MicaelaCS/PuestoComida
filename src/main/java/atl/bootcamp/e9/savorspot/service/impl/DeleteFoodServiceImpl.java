package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import atl.bootcamp.e9.savorspot.service.DeleteFoodService;
import org.springframework.stereotype.Service;

@Service
public class DeleteFoodServiceImpl implements DeleteFoodService {

    private final FoodsRepository foodsRepository;

    public DeleteFoodServiceImpl(FoodsRepository foodsRepository) {
        this.foodsRepository = foodsRepository;
    }
    @Override
    public void deleteFood(long id) {
        foodsRepository.findById(id).orElseThrow();
        foodsRepository.deleteById(id);
    }
}
