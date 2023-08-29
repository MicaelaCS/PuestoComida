package atl.bootcamp.e9.savorpot.service.order;

import atl.bootcamp.e9.savorpot.models.Order;
import atl.bootcamp.e9.savorpot.DTO.FoodOnOrderDTO;

import java.util.List;

public interface CreateOrderFoodService {

    void createOrdenFoods(List<FoodOnOrderDTO> listFoodOnOrderDTO, Order newOrden);
    double getTotal();
}
