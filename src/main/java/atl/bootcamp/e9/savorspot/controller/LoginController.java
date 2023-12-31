package atl.bootcamp.e9.savorspot.controller;


import atl.bootcamp.e9.savorspot.dto.AuthUserDTO;
import atl.bootcamp.e9.savorspot.service.securityService.AuthenticateUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {

    private final AuthenticateUserService authenticateUserService;



    public LoginController(AuthenticateUserService authenticateUserService) {
        this.authenticateUserService = authenticateUserService;
    }

    @PostMapping
    public void login(@RequestBody AuthUserDTO authUserDTO, HttpServletResponse response) {
         authenticateUserService.getUserByCredentials(authUserDTO, response);
    }
}
