package atl.bootcamp.e9.savorpot.service.order;

import org.springframework.http.ResponseEntity;

public interface UpdateOrderStatusService {

    ResponseEntity<String> updateOrder(Long userID, Long id);
}
