package atl.bootcamp.e9.savorspot.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class FoodDTO {

    private String name;
    private double price;
    private String description;
    private String image; // Variable para almacenar la imagen como un arreglo de bytes
    private String foodDrink;



}
