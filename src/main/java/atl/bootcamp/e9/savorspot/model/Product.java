package atl.bootcamp.e9.savorspot.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private String image; // Variable para almacenar la imagen como un arreglo de bytes
    @Column(name = "food_drink")
    private String foodDrink;
    private String description;

   /* @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_food_stand")
    private FoodStall food_stand;*/
}
