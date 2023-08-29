package atl.bootcamp.e9.savorspot.exception.Reviews;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
