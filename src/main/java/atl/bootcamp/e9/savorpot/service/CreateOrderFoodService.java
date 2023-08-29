package atl.bootcamp.e9.savorpot.service;

import atl.bootcamp.e9.savorpot.DTO.FoodOnOrderDTO;
import atl.bootcamp.e9.savorpot.models.Order;

import java.util.List;

public interface CreateOrderFoodService {

    void createOrdenFoods(List<FoodOnOrderDTO> listFoodOnOrderDTO, Order newOrden);
    double getTotal();
}
