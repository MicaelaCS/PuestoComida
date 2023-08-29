package atl.bootcamp.e9.savorspot.service.reviews.impl;

import atl.bootcamp.e9.savorspot.dto.ReviewsDTO.ReviewUpdateDTO;
import atl.bootcamp.e9.savorspot.exception.Reviews.ClienteNotFoundException;
import atl.bootcamp.e9.savorspot.model.Reviews;
import atl.bootcamp.e9.savorspot.repository.ReviewRepository;
import atl.bootcamp.e9.savorspot.service.reviews.servicio.UpdateReviewService;
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
