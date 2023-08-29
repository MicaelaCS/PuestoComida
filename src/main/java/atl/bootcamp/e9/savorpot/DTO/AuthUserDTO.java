package atl.bootcamp.e9.savorpot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthUserDTO {
    private String email;
    private String password;
}
