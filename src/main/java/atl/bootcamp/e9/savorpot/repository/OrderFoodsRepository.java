package atl.bootcamp.e9.savorpot.repository;

import atl.bootcamp.e9.savorpot.models.OrderFoods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFoodsRepository extends CrudRepository<OrderFoods, Long> {

    List<OrderFoods>findByOrder_Id(Long id);
}
