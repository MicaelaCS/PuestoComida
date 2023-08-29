package atl.bootcamp.e9.savorspot.service.order.util;

import atl.bootcamp.e9.savorspot.exception.UserNotFoundException;
import atl.bootcamp.e9.savorspot.model.User;
import atl.bootcamp.e9.savorspot.repository.ClientRepository;
import atl.bootcamp.e9.savorspot.repository.FoodStallRepository;


public final class ValidateUser {

    public static User userType(Long id,
                                FoodStallRepository foodStallRepository,
                                ClientRepository clientRepository){

        return (foodStallRepository.findById(id).isPresent())?
                            foodStallRepository.findById(id).get() :
                            clientRepository.findById(id)
                                    .orElseThrow(() -> new UserNotFoundException("User with ID: "+ id + "not found"));

    }
}
