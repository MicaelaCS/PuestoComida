package atl.bootcamp.e9.savorspot.service.reviews.servicio;

import atl.bootcamp.e9.savorspot.dto.ReviewsDTO.ReviewDTO;
import atl.bootcamp.e9.savorspot.model.Reviews;

import java.util.List;

public interface GetAllReviewsService {
    List<Reviews> getAllReviews();
    List<Reviews> getAllReviews2();
    List<ReviewDTO> getReviewDTOS();
}
