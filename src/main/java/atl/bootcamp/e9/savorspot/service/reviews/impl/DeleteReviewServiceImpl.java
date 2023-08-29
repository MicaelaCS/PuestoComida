package atl.bootcamp.e9.savorspot.service.reviews.impl;

import atl.bootcamp.e9.savorspot.exception.Reviews.ClienteNotFoundException;
import atl.bootcamp.e9.savorspot.model.Reviews;
import atl.bootcamp.e9.savorspot.repository.ReviewRepository;
import atl.bootcamp.e9.savorspot.service.reviews.servicio.DeleteReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewServiceImpl implements DeleteReviewService {
    private final ReviewRepository reviewRepository;

    public DeleteReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ResponseEntity<String> deleteReviews(Long id) {
        Reviews reviews = reviewRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Review not found with ID: " + id));
        reviewRepository.delete(reviews);
        return new ResponseEntity<>("Reviews was successfully removed.", HttpStatus.OK);
    }
}
