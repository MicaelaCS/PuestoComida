package atl.bootcamp.e9.savorspot.service.reviews.servicio;

import org.springframework.http.ResponseEntity;

public interface DeleteReviewService {
    ResponseEntity<String> deleteReviews(Long id);
}
