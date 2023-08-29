package atl.bootcamp.e9.savorpot.service.reviews.util;

import atl.bootcamp.e9.savorpot.repository.OrderFoodsRepository;
import atl.bootcamp.e9.savorpot.DTO.OrderFoodsDTO;
import atl.bootcamp.e9.savorpot.util.MapperOrdenFoods;
import atl.bootcamp.e9.savorpot.models.OrderFoods;

import java.util.ArrayList;
import java.util.List;

public class ListFoodOfOrderService {

    private final OrderFoodsRepository orderFoodsRepository;

    public ListFoodOfOrderService(OrderFoodsRepository orderFoodsRepository) {
        this.orderFoodsRepository = orderFoodsRepository;
    }

    public  List<OrderFoodsDTO> listFoods(Long id) {

        List<OrderFoods> modelOrderFoods = orderFoodsRepository.findByOrder_Id(id);
        List<OrderFoodsDTO> listFoods = new ArrayList<>();

        modelOrderFoods.forEach(
                orderFoods ->
                        listFoods.add(
                                MapperOrdenFoods.mapToOrderFoodDTO(orderFoods)
                        )
        );

       /* for (OrdenComestibles orderFoods: modelOrderFoods) {
                listFoods.add(MapperOrdenFoods.mapToOrderFoodDTO(orderFoods));
        }*/

        return listFoods;
    }
}
