package atl.bootcamp.e9.savorspot.service.ProductService;

import atl.bootcamp.e9.savorspot.dto.ProductDTO;
import atl.bootcamp.e9.savorspot.exception.ProductResourseNotFoundException;
import atl.bootcamp.e9.savorspot.model.Product;
import atl.bootcamp.e9.savorspot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    //injection dependency
    ProductRepository productoRepository;
    public ProductService(ProductRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Post logic
    public ProductDTO createProduct(ProductDTO productDto) {

       Product product = new Product();
       product.setName(productDto.getName());
       product.setPrice(productDto.getPrice());
       product.setDescription(productDto.getDescription());
       productoRepository.save(product);

        return productDto;
    }

    //getAll Logic
    public List<ProductDTO>getAllProduct(){

        List<Product> all = productoRepository.findAll();
        List<ProductDTO> products = new ArrayList<>();

        for (Product product : all){
            ProductDTO productDto = new ProductDTO();
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setDescription(product.getDescription());
            products.add(productDto);
        }
        return products;
    }

    //getProductById Logic
    public ProductDTO getProductById(long id){
        //return productoRepository.findById(id).orElseThrow();

        Product product = productoRepository.findById(id).orElseThrow();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }

    //updateProduct Logic
    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, long id) {
        Product existingProduct = productoRepository.findById(id).orElseThrow();
        //updating existing Product
        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setDescription(productDTO.getDescription());
        //saving existing Product

        productoRepository.save(existingProduct);
        return productDTO;

    }

    //deleting exisiting product
    @Override
    public void deleteProduct(long id) {
        productoRepository.findById(id).orElseThrow();
        productoRepository.deleteById(id);

    }

}