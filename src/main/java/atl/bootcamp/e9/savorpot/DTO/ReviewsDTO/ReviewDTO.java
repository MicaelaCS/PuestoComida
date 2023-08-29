package atl.bootcamp.e9.savorpot.DTO.ReviewsDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {
        private Long id;
        private String comentario;
        private int puntuacion;
        private LocalDateTime dateTimeReviews;
        private ReviewsFootStallDTO reviewsFootStallDTO;
        private ReviewsClientDTO reviewsClientDTO;

}
