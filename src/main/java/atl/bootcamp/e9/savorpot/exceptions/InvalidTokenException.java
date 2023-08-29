package atl.bootcamp.e9.savorpot.exceptions;

import io.jsonwebtoken.SignatureException;

public class InvalidTokenException extends SignatureException {
    public InvalidTokenException(String message) {
        super(message);
    }
}
