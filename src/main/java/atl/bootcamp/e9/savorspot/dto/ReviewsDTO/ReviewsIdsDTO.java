package atl.bootcamp.e9.savorspot.dto.ReviewsDTO;


import lombok.Data;

@Data
public class ReviewsIdsDTO {
    private Long idClient;
    private Long idFoodStall;
    private Long idFood;
    private String comentario;
    private int puntuacion;

}
