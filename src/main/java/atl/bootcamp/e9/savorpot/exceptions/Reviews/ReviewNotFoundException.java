package atl.bootcamp.e9.savorpot.exceptions.Reviews;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
