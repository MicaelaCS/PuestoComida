package atl.bootcamp.e9.savorspot.service.ProductService;

import atl.bootcamp.e9.savorspot.dto.ProductDTO;
import atl.bootcamp.e9.savorspot.model.Product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductServiceInterface{

    //POST in Controller
    ProductDTO createProduct(ProductDTO productDto);

    //getALL in Controller
    List<ProductDTO>getAllProduct();

    //getById in Controller
    ProductDTO getProductById(long id);

    //update in Controller
    ProductDTO updateProduct(ProductDTO product, long id);

    //delete in Controller
    void deleteProduct(long id);






}
