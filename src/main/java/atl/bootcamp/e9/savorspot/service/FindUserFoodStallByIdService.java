package atl.bootcamp.e9.savorspot.service;

import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;

public interface FindUserFoodStallByIdService {
    public UserFoodStallDto findWith(Long id);
}
