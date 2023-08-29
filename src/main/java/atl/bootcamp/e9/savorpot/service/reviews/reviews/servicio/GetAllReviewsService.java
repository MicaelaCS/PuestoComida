package atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio;

import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewDTO;
import atl.bootcamp.e9.savorpot.models.Reviews;

import java.util.List;

public interface GetAllReviewsService {
    List<Reviews> getAllReviews();
    List<Reviews> getAllReviews2();
    List<ReviewDTO> getReviewDTOS();
}
