package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.exception.FoodStallNotFoundException;
import atl.bootcamp.e9.savorspot.model.FoodStall;
import atl.bootcamp.e9.savorspot.model.UserStatus;
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

        FoodStall foodStallToUpdate = foodStallRepository
                .findByIdAndUserStatusNot(id, UserStatus.INACTIVE)
                .orElseThrow(() -> new FoodStallNotFoundException("Food stall with id " + id + " not found"));
        foodStallToUpdate.setUserStatus(UserStatus.INACTIVE);
        foodStallRepository.save(foodStallToUpdate);

    }
}
