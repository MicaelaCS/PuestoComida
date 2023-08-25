package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteFoodService {
    void deleteFood(long id);
}
