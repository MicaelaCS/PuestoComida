package atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio;

import org.springframework.http.ResponseEntity;

public interface DeleteReviewService {
    ResponseEntity<String> deleteReviews(Long id);
}
