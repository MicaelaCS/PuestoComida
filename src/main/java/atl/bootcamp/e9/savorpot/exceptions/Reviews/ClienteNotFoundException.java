package atl.bootcamp.e9.savorpot.exceptions.Reviews;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message){
        super(message);
    }
}
