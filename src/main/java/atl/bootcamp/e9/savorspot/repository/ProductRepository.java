package atl.bootcamp.e9.savorspot.repository;

import atl.bootcamp.e9.savorspot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
