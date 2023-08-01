package atl.bootcamp.e9.savorspot.service.impl;

import atl.bootcamp.e9.savorspot.dto.FoodStallDto;
import atl.bootcamp.e9.savorspot.model.FoodStall;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;
import atl.bootcamp.e9.savorspot.service.ListAllFoodStallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListAllFoodStallServiceImpl implements ListAllFoodStallService {

    private final FoodStallRepository foodStallRepository;

    public ListAllFoodStallServiceImpl(FoodStallRepository foodStallRepository) {
        this.foodStallRepository = foodStallRepository;
    }

    @Override
    public Page<FoodStallDto> list(Pageable pageable) {
        return foodStallRepository.findAll(pageable).map(this::mapToDto);
    }

    private FoodStallDto mapToDto(FoodStall foodStall) {
        return new FoodStallDto(
                foodStall.getId(),
                foodStall.getFoodStallName(),
                foodStall.getAddress(),
                foodStall.getTypeCuisine(),
                foodStall.getAttentionSchedules(),
                foodStall.getPhone(),
                foodStall.getFacadeImageUrl(),
                foodStall.getLatitude(),
                foodStall.getLongitude()
        );
    }
}
