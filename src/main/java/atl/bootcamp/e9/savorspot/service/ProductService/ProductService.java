package atl.bootcamp.e9.savorspot.service.ProductService;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;
import atl.bootcamp.e9.savorspot.model.Foods;
import atl.bootcamp.e9.savorspot.repository.FoodsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    //injection dependency
    FoodsRepository productoRepository;
    public ProductService(FoodsRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Post logic
    public FoodDTO createProduct(FoodDTO foodDto) {

       Foods foods = new Foods();
       foods.setName(foodDto.getName());
       foods.setPrice(foodDto.getPrice());
       foods.setDescription(foodDto.getDescription());
       productoRepository.save(foods);

        return foodDto;
    }

    //getAll Logic
    public List<FoodDTO>getAllProduct(){

        List<Foods> all = productoRepository.findAll();
        List<FoodDTO> products = new ArrayList<>();

        for (Foods foods : all){
            FoodDTO foodDto = new FoodDTO();
            foodDto.setName(foods.getName());
            foodDto.setPrice(foods.getPrice());
            foodDto.setDescription(foods.getDescription());
            products.add(foodDto);
        }
        return products;
    }
    //getProductById Logic
    public FoodDTO getProductById(long id){
        //return productoRepository.findById(id).orElseThrow();

        Foods foods = productoRepository.findById(id).orElseThrow();
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setName(foods.getName());
        foodDTO.setPrice(foods.getPrice());
        foodDTO.setDescription(foods.getDescription());
        return foodDTO;
    }

    //updateProduct Logic
    @Override
    public FoodDTO updateProduct(FoodDTO foodDTO, long id) {

        Foods existingFoods = productoRepository.findById(id).orElseThrow();
        //updating existing Foods
        existingFoods.setName(foodDTO.getName());
        existingFoods.setPrice(foodDTO.getPrice());
        existingFoods.setDescription(foodDTO.getDescription());
        //saving existing Foods

        productoRepository.save(existingFoods);
        return foodDTO;

    }

















    //deleting exisiting product
    @Override
    public void deleteProduct(long id) {
        productoRepository.findById(id).orElseThrow();
        productoRepository.deleteById(id);

    }

}