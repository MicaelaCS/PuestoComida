package atl.bootcamp.e9.savorspot.repository;

import atl.bootcamp.e9.savorspot.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends UserRepository<Client, Long>{
}
