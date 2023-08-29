package atl.bootcamp.e9.savorpot.repository;

import atl.bootcamp.e9.savorpot.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
