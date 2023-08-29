package atl.bootcamp.e9.savorpot.service.reviews.reviews.impl;

import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.CreateReviewsService;
import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewsIdsDTO;
import atl.bootcamp.e9.savorpot.exceptions.FoodNotFoundException;
import atl.bootcamp.e9.savorpot.exceptions.Reviews.ClienteNotFoundException;
import atl.bootcamp.e9.savorpot.exceptions.Reviews.FoodStallNotFoundException;
import atl.bootcamp.e9.savorpot.models.Client;
import atl.bootcamp.e9.savorpot.models.FoodStall;
import atl.bootcamp.e9.savorpot.models.Foods;
import atl.bootcamp.e9.savorpot.models.User;
import atl.bootcamp.e9.savorpot.repository.ClientRepository;
import atl.bootcamp.e9.savorpot.repository.FoodStellRepository;
import atl.bootcamp.e9.savorpot.repository.FoodsRepository;
import atl.bootcamp.e9.savorpot.repository.ReviewRepository;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.util.MapperReviews;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateReviewServiceImpl implements CreateReviewsService {

    private final ClientRepository clientRepository;
    private final FoodStellRepository foodStallRepository;
    private final FoodsRepository foodRepository;
    private final ReviewRepository reviewRepository;

      public CreateReviewServiceImpl(ClientRepository clientRepository, FoodStellRepository foodStallRepository,
                                   FoodsRepository foodRepository, ReviewRepository reviewRepository) {
        this.clientRepository = clientRepository;
        this.foodStallRepository = foodStallRepository;
        this.foodRepository = foodRepository;
        this.reviewRepository = reviewRepository;

    }

    @Transactional
    @Override
    public ResponseEntity<String> newReview( ReviewsIdsDTO reviewsIdsDTO)  {

        try {
            Client client = clientRepository.findById(reviewsIdsDTO.getIdClient())
                    .orElseThrow(() -> new ClienteNotFoundException("Client not found with ID: " + reviewsIdsDTO.getIdClient()));

            User foodStall = foodStallRepository.findById(reviewsIdsDTO.getIdFoodStall())
                    .orElseThrow(() -> new FoodStallNotFoundException("Food stall not found with ID: " + reviewsIdsDTO.getIdFoodStall()));

            Foods foods = foodRepository.findById(reviewsIdsDTO.getIdFood())
                    .orElseThrow(() -> new FoodNotFoundException("Food not found with ID: " + reviewsIdsDTO.getIdFood()));

            reviewRepository.save(MapperReviews.mapperToReview(client, (FoodStall) foodStall,foods));

            return new ResponseEntity<>("Review successfully created.", HttpStatus.CREATED);
        } catch (ClienteNotFoundException | FoodStallNotFoundException | FoodNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

