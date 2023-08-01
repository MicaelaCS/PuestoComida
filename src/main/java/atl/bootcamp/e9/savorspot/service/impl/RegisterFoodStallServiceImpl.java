package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.RegisterFoodStallDto;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.RegisterFoodService;
import atl.bootcamp.e9.savorspot.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterFoodStallServiceImpl implements RegisterFoodService {

    private final FoodStallRepository foodStallRepository;

    public RegisterFoodStallServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public void create(RegisterFoodStallDto registerNewFoodStallDto) {
        foodStallRepository.save(Mapper.mapToFoodStall(registerNewFoodStallDto));
    }
}
