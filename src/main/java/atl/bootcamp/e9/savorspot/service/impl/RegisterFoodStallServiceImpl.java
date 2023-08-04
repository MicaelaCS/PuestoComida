package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.RegisterUserFoodStallDto;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.RegisterFoodStallService;
import atl.bootcamp.e9.savorspot.util.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterFoodStallServiceImpl implements RegisterFoodStallService {

    private final FoodStallRepository foodStallRepository;

    public RegisterFoodStallServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public void register(RegisterUserFoodStallDto registerUserFoodStallDto) {
        foodStallRepository.save(UserMapper.mapToFoodStallToRegister(registerUserFoodStallDto));
    }
}