package atl.bootcamp.e9.savorpot.service;

import atl.bootcamp.e9.savorpot.DTO.OrderDTO;

public interface GetOrderByIdService {
    OrderDTO getOrderbyId(Long id, Long userID);
}
