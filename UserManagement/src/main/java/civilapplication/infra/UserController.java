package civilapplication.infra;

import civilapplication.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/users")
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(
        value = "/users/authenticateuser",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public User authenticateUser(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody AuthenticateUserCommand authenticateUserCommand
    ) throws Exception {
        System.out.println("##### /user/authenticateUser  called #####");
        User user = new User();
        user.authenticateUser(authenticateUserCommand);
        userRepository.save(user);
        return user;
    }
}
//>>> Clean Arch / Inbound Adaptor
