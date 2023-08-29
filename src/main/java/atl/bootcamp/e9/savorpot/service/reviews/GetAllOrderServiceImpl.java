package atl.bootcamp.e9.savorpot.service.reviews;

import atl.bootcamp.e9.savorpot.repository.ClientRepository;
import atl.bootcamp.e9.savorpot.repository.FoodStellRepository;
import atl.bootcamp.e9.savorpot.repository.OrderFoodsRepository;
import atl.bootcamp.e9.savorpot.repository.OrderRepository;
import atl.bootcamp.e9.savorpot.service.reviews.util.ListOrdersService;
import atl.bootcamp.e9.savorpot.service.reviews.util.ValidateUser;
import atl.bootcamp.e9.savorpot.DTO.OrderDTO;
import atl.bootcamp.e9.savorpot.models.Order;
import atl.bootcamp.e9.savorpot.models.User;
import atl.bootcamp.e9.savorpot.models.UserType;

import atl.bootcamp.e9.savorpot.service.GetAllOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllOrderServiceImpl implements GetAllOrderService {
    private final OrderRepository orderRepository;
    private final ListOrdersService listOrdersService;

    private final FoodStellRepository foodStallRepository;
    private final ClientRepository clientRepository;

    public GetAllOrderServiceImpl(OrderRepository orderRepository,
                                                OrderFoodsRepository orderFoodsRepository,
                                                  FoodStellRepository foodStallRepository,
                                                  ClientRepository clientRepository) {

        this.orderRepository = orderRepository;
        this.listOrdersService = new ListOrdersService(orderFoodsRepository);
        this.foodStallRepository = foodStallRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<OrderDTO> getAllOrder(Long userID) {

        User user = ValidateUser.userType(userID,foodStallRepository, clientRepository);
        List<Order> modelOrder;

        if(user.getUserType().equals(UserType.FOOD_STALL)) {
            modelOrder = orderRepository.findOrdersByFoodStall_Id(user.getId());
        }else{
            modelOrder = orderRepository.findOrdersByClient_Id(user.getId());
        }

        return listOrdersService.listOrder(modelOrder);
    }
}
