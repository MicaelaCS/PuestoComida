package atl.bootcamp.e9.savorpot.service;

import org.springframework.http.ResponseEntity;

public interface SoftDeleteOrderStatusService {

    ResponseEntity<String> softDeleteOrder(Long id);
}
