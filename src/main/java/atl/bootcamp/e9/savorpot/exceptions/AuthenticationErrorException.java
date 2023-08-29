package atl.bootcamp.e9.savorpot.exceptions;

public class AuthenticationErrorException extends RuntimeException{
    public AuthenticationErrorException(String message) {
        super(message);
    }
}
