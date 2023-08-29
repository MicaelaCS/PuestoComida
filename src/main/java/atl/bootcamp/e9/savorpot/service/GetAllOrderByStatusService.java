package atl.bootcamp.e9.savorpot.service;

import atl.bootcamp.e9.savorpot.DTO.OrderDTO;
import atl.bootcamp.e9.savorpot.models.OrderStatus;

import java.util.List;

public interface GetAllOrderByStatusService {

    List<OrderDTO> getAllOrderByStatus(Long userID, OrderStatus orderStatus);
}
