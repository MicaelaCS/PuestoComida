package atl.bootcamp.e9.savorpot.service.order;

import atl.bootcamp.e9.savorpot.models.OrderStatus;
import atl.bootcamp.e9.savorpot.DTO.OrderDTO;

import java.util.List;

public interface GetAllOrderByStatusService {

    List<OrderDTO> getAllOrderByStatus(Long userID, OrderStatus orderStatus);
}
