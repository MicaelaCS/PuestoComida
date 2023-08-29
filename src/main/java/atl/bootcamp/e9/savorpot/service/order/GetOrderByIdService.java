package atl.bootcamp.e9.savorpot.service.order;

import atl.bootcamp.e9.savorpot.DTO.OrderDTO;

public interface GetOrderByIdService {
    OrderDTO getOrderbyId(Long id, Long userID);
}
