package atl.bootcamp.e9.savorpot.service.reviews.reviews.impl;

import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewDTO;
import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewsClientDTO;
import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewsFootStallDTO;
import atl.bootcamp.e9.savorpot.models.Reviews;
import atl.bootcamp.e9.savorpot.repository.ReviewRepository;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.GetAllReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllReviewServiceImpl implements GetAllReviewsService {
    private final ReviewRepository reviewRepository;


    public GetAllReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;

    }

    @Override
    public List<Reviews> getAllReviews(){

        return (List<Reviews>) reviewRepository.findAll();
    }

    @Override
    public List<Reviews> getAllReviews2() {
        return (List<Reviews>) reviewRepository.findAll();
    }

    public List<ReviewDTO> getReviewDTOS() {
        return getAllReviews().stream()
                .map(reviews -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setId(reviews.getId());
                    reviewDTO.setComentario(reviews.getComentario());
                    reviewDTO.setPuntuacion(reviews.getPuntuacion());
                    reviewDTO.setDateTimeReviews(reviews.getDateTimeReviews());

                    ReviewsFootStallDTO reviewsFootStallDTO = new ReviewsFootStallDTO();
                    reviewsFootStallDTO.setFoodStallName(reviews.getFoodStall().getFoodStallName());
                    reviewDTO.setReviewsFootStallDTO(reviewsFootStallDTO);

                    ReviewsClientDTO reviewsClientDTO = new ReviewsClientDTO();
                    reviewsClientDTO.setFullName(reviews.getClient().getFullName());
                    reviewsClientDTO.setStatus(String.valueOf(reviews.getClient().getUserStatus()));
                    reviewDTO.setReviewsClientDTO(reviewsClientDTO);
                    return reviewDTO;
                }).collect(Collectors.toList());
    }

}
