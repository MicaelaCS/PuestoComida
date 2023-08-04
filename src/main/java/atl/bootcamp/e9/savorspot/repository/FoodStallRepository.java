package atl.bootcamp.e9.savorspot.repository;

import atl.bootcamp.e9.savorspot.model.FoodStall;
import atl.bootcamp.e9.savorspot.model.UserStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodStallRepository extends UserRepository<FoodStall, Long>{

    Page<FoodStall> findByUserStatusNot(UserStatus userStatus, Pageable pageable);

    Optional<FoodStall> findByIdAndUserStatusNot(Long id, UserStatus userStatus);
}
