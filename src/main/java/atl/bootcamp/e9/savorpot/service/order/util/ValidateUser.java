package atl.bootcamp.e9.savorpot.service.order.util;

import atl.bootcamp.e9.savorpot.exceptions.UserNotFoundException;
import atl.bootcamp.e9.savorpot.repository.ClientRepository;
import atl.bootcamp.e9.savorpot.models.User;
import atl.bootcamp.e9.savorpot.repository.FoodStallRepository;


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
