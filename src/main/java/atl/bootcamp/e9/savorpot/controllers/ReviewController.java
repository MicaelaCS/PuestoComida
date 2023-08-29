package atl.bootcamp.e9.savorpot.controllers;

import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewDTO;
import atl.bootcamp.e9.savorpot.security.JWTUtil;
import atl.bootcamp.e9.savorpot.security.ValidateToken;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.CreateReviewsService;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.GetAllReviewsService;
import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewUpdateDTO;
import atl.bootcamp.e9.savorpot.DTO.ReviewsDTO.ReviewsIdsDTO;
import atl.bootcamp.e9.savorpot.models.Reviews;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.DeleteReviewService;
import atl.bootcamp.e9.savorpot.service.reviews.reviews.servicio.UpdateReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final CreateReviewsService createReviewsService;
    private final GetAllReviewsService getAllReviewsService;
    private final UpdateReviewService updateReviewService;
    private final DeleteReviewService deleteReviewService;

    private final ValidateToken validateToken;

     public ReviewController(CreateReviewsService createReviewsService,
                             GetAllReviewsService getAllReviewsService,
                             UpdateReviewService updateReviewService,
                             DeleteReviewService deleteReviewService,
                             JWTUtil jwtUtil) throws Exception {

        this.createReviewsService = createReviewsService;
        this.getAllReviewsService = getAllReviewsService;
        this.updateReviewService = updateReviewService;
        this.deleteReviewService = deleteReviewService;
        validateToken = new ValidateToken(jwtUtil);
     }

    @PostMapping("/api/review")
    public ResponseEntity<String> createReview(@RequestHeader(value="Authorization") String token,
                                               @RequestBody ReviewsIdsDTO reviewsIdsDTO) throws Exception{

        if (!validateToken.isValidToken(token)) return null;
        return  createReviewsService.newReview(reviewsIdsDTO);
    }

    @GetMapping("/api/reviews")
    public List<ReviewDTO> getReviewsAll(@RequestHeader(value="Authorization") String token){
        if (!validateToken.isValidToken(token)) return null;
        return getAllReviewsService.getReviewDTOS();
    }

    @GetMapping("/api/reviews/2")
    public List<Reviews> getReviewsAll2(@RequestHeader(value="Authorization") String token){
        if (!validateToken.isValidToken(token)) return null;
        return getAllReviewsService.getAllReviews2();

    }

    @PutMapping("/api/reviews/{id}")
    public ResponseEntity<String> updateReview(@RequestHeader(value="Authorization") String token,
                                               @RequestBody ReviewUpdateDTO reviewUpdateDTO, @PathVariable Long id) {
        if (!validateToken.isValidToken(token)) return null;
        return updateReviewService.updateReview(reviewUpdateDTO, id);
    }

    @DeleteMapping("/api/reviews/{id}")
    public ResponseEntity<String> deleteReview(@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!validateToken.isValidToken(token)) return null;
        return deleteReviewService.deleteReviews(id);
    }
}
