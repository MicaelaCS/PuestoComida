package atl.bootcamp.e9.savorspot.service.order.util;

import atl.bootcamp.e9.savorspot.dto.OrderDTO;
import atl.bootcamp.e9.savorspot.model.Order;
import atl.bootcamp.e9.savorspot.repository.OrderFoodsRepository;
import atl.bootcamp.e9.savorspot.service.order.mappers.MapperOrden;

import java.util.ArrayList;
import java.util.List;

public class ListOrdersService {
    private final ListFoodOfOrderService listFoodOfOrderService;

    public ListOrdersService(OrderFoodsRepository orderFoodsRepository) {
        this.listFoodOfOrderService = new ListFoodOfOrderService(orderFoodsRepository);
    }

    public List<OrderDTO> listOrder(List<Order> modelOrder) {

        List<OrderDTO> listOrdersDTO = new ArrayList<>();

        modelOrder.forEach(
                order -> {
                    OrderDTO orderDTO;
                    orderDTO = MapperOrden.mapToOrderDTO(order);

                    listOrdersDTO.add(
                            MapperOrden.mapFoodsOfOrderDTO(orderDTO, listFoodOfOrderService.listFoods(order.getId()))
                    );
                }
        );

        return listOrdersDTO;
    }
}
