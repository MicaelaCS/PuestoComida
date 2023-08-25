package atl.bootcamp.e9.savorspot.controller;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import atl.bootcamp.e9.savorspot.service.CreateFoodService;
import atl.bootcamp.e9.savorspot.service.GetAllFoodService;
import atl.bootcamp.e9.savorspot.service.impl.DeleteFoodServiceImpl;
import atl.bootcamp.e9.savorspot.service.impl.GetFoodByIdServiceImpl;
import atl.bootcamp.e9.savorspot.service.impl.UpdateFoodServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class FoodsController {


    //injection service dependency
    private CreateFoodService createFoodService;
    private GetAllFoodService getAllFoodService;
    private GetFoodByIdServiceImpl getFoodByIdService;
    private UpdateFoodServiceImpl updateFoodService;
    private DeleteFoodServiceImpl deleteFoodService;
    //  -----------------------// -------------------------//

    public FoodsController(CreateFoodService createFoodService,
                           GetAllFoodService getAllFoodService,
                           GetFoodByIdServiceImpl getFoodByIdService,
                           UpdateFoodServiceImpl updateFoodService,
                           DeleteFoodServiceImpl deleteFoodService) {

        this.createFoodService = createFoodService;
        this.getAllFoodService = getAllFoodService;
        this.getFoodByIdService = getFoodByIdService;
        this.updateFoodService = updateFoodService;
        this.deleteFoodService = deleteFoodService;
    }

    //build save Employee REST API
    @PostMapping
    public ResponseEntity<FoodDTO>createFood(@RequestBody FoodDTO foodDto){
        return new ResponseEntity<FoodDTO>(createFoodService.createFood(foodDto), HttpStatus.CREATED);
    }

    //build get all Foods REST API
    @GetMapping
    public List<FoodDTO> getAllFood(){
        return getAllFoodService.getAllFoods();
    }

    //build getProductById REST API
    @GetMapping("{id}")
    public ResponseEntity<FoodDTO>getFoodById(@PathVariable("id") long id){
        return new ResponseEntity<FoodDTO>(getFoodByIdService.getFoodById(id), HttpStatus.OK);
    }

    //build updateProductById REST API
    @PutMapping("{id}")
    public ResponseEntity<FoodDTO>updateFoodById(@PathVariable("id")long id, @RequestBody FoodDTO food){
        return new ResponseEntity<FoodDTO>(updateFoodService.updateFood(food,id ), HttpStatus.OK);
    }
    //build deleteProduct REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteFood(@PathVariable("id")long id){
        deleteFoodService.deleteFood(id);
        return new ResponseEntity<String>("Foods deleted successfully!.", HttpStatus.OK);
    }
}

