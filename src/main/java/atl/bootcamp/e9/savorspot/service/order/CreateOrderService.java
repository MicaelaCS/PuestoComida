package atl.bootcamp.e9.savorspot.service.order;

import atl.bootcamp.e9.savorspot.dto.OrderRequestDTO;
import org.springframework.http.ResponseEntity;

public interface CreateOrderService {
    ResponseEntity<String> createOrden(Long clientID, OrderRequestDTO orderRequestDTO);
}
