package atl.bootcamp.e9.savorpot.service.securityService;

import atl.bootcamp.e9.savorpot.DTO.AuthUserDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticateUserService {

    void getUserByCredentials(AuthUserDTO authUserDTO, HttpServletResponse response);
}
