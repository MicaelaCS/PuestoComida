package atl.bootcamp.e9.savorpot.service.reviews.reviews.impl;

import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.DeleteReviewService;
import atl.bootcamp.e9.savorpot.exceptions.Reviews.ClienteNotFoundException;
import atl.bootcamp.e9.savorpot.models.Reviews;
import atl.bootcamp.e9.savorpot.repository.ReviewRepository;
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
