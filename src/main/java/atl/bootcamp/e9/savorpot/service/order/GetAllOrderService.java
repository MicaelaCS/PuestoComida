package atl.bootcamp.e9.savorpot.service.order;

import atl.bootcamp.e9.savorpot.DTO.OrderDTO;

import java.util.List;

public interface GetAllOrderService {

    List<OrderDTO> getAllOrder(Long userID);
}
