package atl.bootcamp.e9.savorpot.service.reviews.reviews.impl;

import atl.bootcamp.e9.savorpot.exceptions.Reviews.ClienteNotFoundException;
import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewUpdateDTO;
import atl.bootcamp.e9.savorpot.models.Reviews;
import atl.bootcamp.e9.savorpot.repository.ReviewRepository;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.UpdateReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateReviewServiceImpl implements UpdateReviewService {

    private final ReviewRepository reviewRepository;

    public UpdateReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ResponseEntity<String> updateReview(ReviewUpdateDTO reviewUpdateDTO, Long id) {

        Reviews reviews = reviewRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Client not found with ID: " + id));

        reviews.setComentario(reviewUpdateDTO.getComentario());
        reviews.setPuntuacion(reviewUpdateDTO.getPuntuacion());
        reviewRepository.save(reviews);
        return new ResponseEntity<>("it was updated successfully", HttpStatus.OK);
    }
}
