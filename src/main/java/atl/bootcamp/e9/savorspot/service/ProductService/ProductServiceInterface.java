package atl.bootcamp.e9.savorspot.service.ProductService;

import atl.bootcamp.e9.savorspot.dto.FoodDTO;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductServiceInterface{

    //POST in Controller
    //FoodDTO createProduct(FoodDTO foodDto);

    //getALL in Controller
    //List<FoodDTO>getAllProduct();

    //getById in Controller
    FoodDTO getProductById(long id);

    //update in Controller
    FoodDTO updateProduct(FoodDTO product, long id);

    //delete in Controller
    void deleteProduct(long id);






}
