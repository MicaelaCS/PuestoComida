package atl.bootcamp.e9.savorspot.service.reviews.servicio;

import atl.bootcamp.e9.savorspot.dto.ReviewsDTO.ReviewsIdsDTO;
import org.springframework.http.ResponseEntity;


public interface CreateReviewsService {
   ResponseEntity<String> newReview(ReviewsIdsDTO reviewsIdsDTO) throws Exception;



}
