package atl.bootcamp.e9.savorspot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductResourseNotFoundException extends RuntimeException{


}
