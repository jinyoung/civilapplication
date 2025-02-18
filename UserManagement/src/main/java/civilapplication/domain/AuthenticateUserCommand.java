package civilapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AuthenticateUserCommand {

    private String username;
    private String password;
}
