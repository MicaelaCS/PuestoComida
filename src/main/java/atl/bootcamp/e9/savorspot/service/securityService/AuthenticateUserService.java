package atl.bootcamp.e9.savorspot.service.securityService;

import atl.bootcamp.e9.savorspot.dto.AuthUserDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticateUserService {

    void getUserByCredentials(AuthUserDTO authUserDTO, HttpServletResponse response);
}
