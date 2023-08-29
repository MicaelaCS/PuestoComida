package atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio;

import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewsIdsDTO;
import org.springframework.http.ResponseEntity;


public interface CreateReviewsService {
   ResponseEntity<String> newReview(ReviewsIdsDTO reviewsIdsDTO) throws Exception;



}
