package atl.bootcamp.e9.savorspot.repository;

import atl.bootcamp.e9.savorspot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<T extends User, ID> extends JpaRepository<T, ID> {
    Optional<User> findUserByEmail(String email);
}
