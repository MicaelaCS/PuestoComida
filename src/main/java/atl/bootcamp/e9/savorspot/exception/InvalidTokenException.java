package atl.bootcamp.e9.savorspot.exception;

import io.jsonwebtoken.SignatureException;


public class InvalidTokenException extends SignatureException {
    public InvalidTokenException(String message) {
        super(message);
    }
}
