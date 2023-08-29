package atl.bootcamp.e9.savorpot.service.order;

import org.springframework.http.ResponseEntity;

public interface SoftDeleteOrderStatusService {

    ResponseEntity<String> softDeleteOrder(Long id);
}
