package atl.bootcamp.e9.savorpot.service.order;

import atl.bootcamp.e9.savorpot.DTO.OrderRequestDTO;
import org.springframework.http.ResponseEntity;

public interface CreateOrderService {
    ResponseEntity<String> createOrden(Long clientID, OrderRequestDTO orderRequestDTO);
}
