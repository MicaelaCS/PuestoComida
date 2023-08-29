package atl.bootcamp.e9.savorpot.service.reviews.util;

import atl.bootcamp.e9.savorpot.exceptions.UserNotFoundException;
import atl.bootcamp.e9.savorpot.repository.ClientRepository;
import atl.bootcamp.e9.savorpot.repository.FoodStellRepository;
import atl.bootcamp.e9.savorpot.models.User;


public final class ValidateUser {

    public static User userType(Long id,
                                FoodStellRepository foodStallRepository,
                                ClientRepository clientRepository){

        return (foodStallRepository.findById(id).isPresent())?
                            foodStallRepository.findById(id).get() :
                            clientRepository.findById(id)
                                    .orElseThrow(() -> new UserNotFoundException("User with ID: "+ id + "not found"));

    }
}
