package atl.bootcamp.e9.savorspot.controller;

import atl.bootcamp.e9.savorspot.dto.ProductDTO;
import atl.bootcamp.e9.savorspot.model.Product;
import atl.bootcamp.e9.savorspot.service.ProductService.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    //injection service dependency
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //build save Employee REST API
    @PostMapping
    public ResponseEntity<ProductDTO>createProduct(@RequestBody ProductDTO productDto){
        return new ResponseEntity<ProductDTO>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    //build get all Product REST API
    @GetMapping
    public List<ProductDTO>getAllProdct(){
        return productService.getAllProduct();
    }

    //build getProductById REST API
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO>getProductById(@PathVariable("id") long id){
        return new ResponseEntity<ProductDTO>(productService.getProductById(id), HttpStatus.OK);
    }

    //build updateProductById REST API
    @PutMapping("{id}")
    public ResponseEntity<ProductDTO>updateProductById(@PathVariable("id")long id, @RequestBody ProductDTO product){
        return new ResponseEntity<ProductDTO>(productService.updateProduct(product,id ), HttpStatus.OK);
    }

    //build deleteProduct REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable("id")long id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
    }


}

