package atl.bootcamp.e9.savorspot.exception;

public class AuthenticationErrorException extends RuntimeException{
    public AuthenticationErrorException(String message) {
        super(message);
    }
}
