package atl.bootcamp.e9.savorpot.service.reviews.util;

import atl.bootcamp.e9.savorpot.repository.OrderFoodsRepository;
import atl.bootcamp.e9.savorpot.DTO.OrderDTO;
import atl.bootcamp.e9.savorpot.util.MapperOrden;
import atl.bootcamp.e9.savorpot.models.Order;

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
                            MapperOrden.mapFoodsOfOrderDTO(orderDTO, listFoodOfOrderService.listFoods(order.getId())
                            )
                    );
                }
        );

      /*  for (Orden order : modelOrder) {
            OrderDTO orderDTO;

            orderDTO = MapperOrden.mapToOrderDTO(order);
            listOrdersDTO.add(
                    MapperOrden.mapFoodsOfOrderDTO(
                            orderDTO,
                            listFoodOfOrderService.listFoods(order.getId())
                    )
            );
        }*/

        return listOrdersDTO;
    }
}
