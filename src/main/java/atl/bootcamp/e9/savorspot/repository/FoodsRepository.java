package atl.bootcamp.e9.savorspot.repository;

import atl.bootcamp.e9.savorspot.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsRepository extends JpaRepository<Foods, Long> {
}
