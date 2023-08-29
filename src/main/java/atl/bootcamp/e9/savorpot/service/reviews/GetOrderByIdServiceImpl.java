package atl.bootcamp.e9.savorpot.service.reviews;

import atl.bootcamp.e9.savorpot.exceptions.NotPermitsUserException;
import atl.bootcamp.e9.savorpot.exceptions.OrderNotFoundException;
import atl.bootcamp.e9.savorpot.repository.OrderFoodsRepository;
import atl.bootcamp.e9.savorpot.repository.OrderRepository;
import atl.bootcamp.e9.savorpot.service.reviews.util.ListOrdersService;
import atl.bootcamp.e9.savorpot.DTO.OrderDTO;
import atl.bootcamp.e9.savorpot.models.Order;
import atl.bootcamp.e9.savorpot.service.GetOrderByIdService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetOrderByIdServiceImpl implements GetOrderByIdService {

    private final OrderRepository ordenRepository;
    private final ListOrdersService listOrdersService;

    public GetOrderByIdServiceImpl(OrderRepository orderRepository,
                                                    OrderFoodsRepository orderFoodsRepository) {

        this.ordenRepository = orderRepository;
        listOrdersService = new ListOrdersService(orderFoodsRepository);
    }

    @Override
    public OrderDTO getOrderbyId(Long orderID, Long userID) {

        List<Order> modelOrder = new ArrayList<>();

        Order order = ordenRepository.findById(orderID)
                .orElseThrow(()-> new OrderNotFoundException("Order with ID: "+orderID+" not found"));


        if(order.getFoodStall().getId().equals(userID)){
            modelOrder.add(order);
        }
        else if(order.getClient().getId().equals(userID)){
            modelOrder.add(order);
        }else {
            throw new NotPermitsUserException("It is not possible to perform this action for Order with ID :" + orderID);
        }

        return listOrdersService.listOrder(modelOrder).get(0);
    }
}
