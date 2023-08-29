package atl.bootcamp.e9.savorpot.service.order.mappers;

import atl.bootcamp.e9.savorpot.DTO.FoodOnOrderDTO;
import atl.bootcamp.e9.savorpot.DTO.OrderFoodsDTO;
import atl.bootcamp.e9.savorpot.models.Foods;
import atl.bootcamp.e9.savorpot.models.Order;
import atl.bootcamp.e9.savorpot.models.OrderFoods;


public final class MapperOrdenFoods {

    private MapperOrdenFoods() {
        throw new UnsupportedOperationException("A static class cannot be instantiated");
    }

    public static OrderFoods mapToOrdenFood(Foods food,
                                            Order newOrden,
                                            FoodOnOrderDTO foodOnOrderDTO) {

        OrderFoods orderFoods = new OrderFoods();

        orderFoods.setOrder(newOrden);
        orderFoods.setFood(food);
        orderFoods.setQuantity(foodOnOrderDTO.getQuantity());

        return orderFoods;
    }

    public static OrderFoodsDTO mapToOrderFoodDTO(OrderFoods orderFoods){

        return new OrderFoodsDTO(
                                    orderFoods.getFood().getName(),
                                    orderFoods.getFood().getDescription(),
                                    orderFoods.getQuantity(),
                                    orderFoods.getFood().getPrice());
    }
}
