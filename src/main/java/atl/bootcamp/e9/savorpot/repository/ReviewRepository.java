package atl.bootcamp.e9.savorpot.repository;

import atl.bootcamp.e9.savorpot.models.Reviews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Reviews, Long> {

}
