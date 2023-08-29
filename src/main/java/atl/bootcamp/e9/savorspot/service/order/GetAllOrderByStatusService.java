package atl.bootcamp.e9.savorspot.service.order;

import atl.bootcamp.e9.savorspot.dto.OrderDTO;
import atl.bootcamp.e9.savorspot.model.OrderStatus;

import java.util.List;

public interface GetAllOrderByStatusService {

    List<OrderDTO> getAllOrderByStatus(Long userID, OrderStatus orderStatus);
}
