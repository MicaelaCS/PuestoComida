package atl.bootcamp.e9.savorspot.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="foods")
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private String image; // Variable para almacenar la imagen como un arreglo de bytes
    @Column(name = "food_drink")
    private String foodDrink;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodStall_id")
    private FoodStall food_stand;
}
