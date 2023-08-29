package atl.bootcamp.e9.savorpot.service.reviews;

import atl.bootcamp.e9.savorpot.exceptions.NotPermitsUserException;
import atl.bootcamp.e9.savorpot.exceptions.OrderNotFoundException;
import atl.bootcamp.e9.savorpot.repository.ClientRepository;
import atl.bootcamp.e9.savorpot.repository.FoodStellRepository;
import atl.bootcamp.e9.savorpot.repository.OrderRepository;
import atl.bootcamp.e9.savorpot.util.MapperOrden;
import atl.bootcamp.e9.savorpot.models.Order;
import atl.bootcamp.e9.savorpot.models.OrderStatus;
import atl.bootcamp.e9.savorpot.models.User;
import atl.bootcamp.e9.savorpot.models.UserType;
import atl.bootcamp.e9.savorpot.service.UpdateOrderStatusService;
import atl.bootcamp.e9.savorpot.service.reviews.util.ValidateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderStatusServiceImpl implements UpdateOrderStatusService {

    private final OrderRepository orderRepository;
    private final FoodStellRepository foodStallRepository;
    private final ClientRepository clientRepository;

    public UpdateOrderStatusServiceImpl(OrderRepository orderRepository,
                                                            FoodStellRepository foodStallRepository,
                                                            ClientRepository clientRepository) {

        this.orderRepository = orderRepository;
        this.foodStallRepository = foodStallRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<String> updateOrder(Long userID, Long orderID) {

        Order order;
        User user = ValidateUser.userType(userID, foodStallRepository, clientRepository);

        if (user.getUserType().equals(UserType.FOOD_STALL)) {

            order = orderRepository.findByIdAndStateNot(orderID, OrderStatus.CANCELED)
                    .orElseThrow(() ->
                            new OrderNotFoundException("It is not possible to perform this action for Order with ID: " + orderID+
                                                                         " because it has CANCELED status."));

            orderRepository.save(MapperOrden.mapToUpdateOrder(order));

            return ResponseEntity.ok("Order successfully update");
        }

        throw new NotPermitsUserException("You don't have permits, you need to be a food stand");
    }
}
