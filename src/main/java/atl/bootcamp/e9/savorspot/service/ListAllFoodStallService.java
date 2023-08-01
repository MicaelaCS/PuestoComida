package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.dto.FoodStallDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListAllFoodStallService {
    Page<FoodStallDto> list(Pageable pageable);
}
