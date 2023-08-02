package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.exception.FoodStallNostFoundException;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.DeleteFoodStallByIdService;
import org.springframework.stereotype.Service;

@Service
public class DeleteFoodStallByIdServiceImpl implements DeleteFoodStallByIdService {

    private final FoodStallRepository foodStallRepository;

    public DeleteFoodStallByIdServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public void deleteWith(Long id) {

        if(!foodStallRepository.existsById(id)) {
            throw new FoodStallNostFoundException("Food stall with id " + id + " not found");
        }

        foodStallRepository.deleteById(id);

    }
}
