package atl.bootcamp.e9.savorpot.service.reviews.reviews.util;

import atl.bootcamp.e9.savorpot.models.Client;
import atl.bootcamp.e9.savorpot.models.FoodStall;
import atl.bootcamp.e9.savorpot.models.Foods;
import atl.bootcamp.e9.savorpot.models.Reviews;

import java.time.LocalDateTime;

public final class MapperReviews {


    private MapperReviews() { throw new UnsupportedOperationException("A static class cannot be instantiated");
    }

    public static Reviews mapperToReview (Client client, FoodStall foodStall, Foods foods){

        Reviews reviews = new Reviews();
        reviews.setClient(client);
        reviews.setFood(foods);
        reviews.setFoodStall(foodStall);
        reviews.setDateTimeReviews(LocalDateTime.now());
        return  reviews;
    }
}
