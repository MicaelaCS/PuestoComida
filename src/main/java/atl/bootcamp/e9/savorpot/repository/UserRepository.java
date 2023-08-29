package atl.bootcamp.e9.savorpot.repository;

import atl.bootcamp.e9.savorpot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<F extends User, L extends Number> extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
