package atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio;

import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewUpdateDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateReviewService {
    ResponseEntity<String> updateReview(ReviewUpdateDTO reviewUpdateDTO, Long id);
}
