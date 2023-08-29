package atl.bootcamp.e9.savorspot.service.order;

import atl.bootcamp.e9.savorspot.dto.FoodOnOrderDTO;
import atl.bootcamp.e9.savorspot.model.Order;

import java.util.List;

public interface CreateOrderFoodService {

    void createOrdenFoods(List<FoodOnOrderDTO> listFoodOnOrderDTO, Order newOrden);
    double getTotal();
}
