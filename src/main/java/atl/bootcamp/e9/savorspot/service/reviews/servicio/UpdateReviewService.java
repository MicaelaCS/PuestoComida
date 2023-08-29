package atl.bootcamp.e9.savorspot.service.reviews.servicio;

import atl.bootcamp.e9.savorspot.dto.ReviewsDTO.ReviewUpdateDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateReviewService {
    ResponseEntity<String> updateReview(ReviewUpdateDTO reviewUpdateDTO, Long id);
}
