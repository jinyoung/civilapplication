package civilapplication.domain;

import civilapplication.UserManagementApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    private String userId;

    @Embedded
    private UserCredential userCredential;

    public static UserRepository repository() {
        UserRepository userRepository = UserManagementApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public void authenticateUser(
        AuthenticateUserCommand authenticateUserCommand
    ) {
        //implement business logic here:

        UserAuthenticated userAuthenticated = new UserAuthenticated(this);
        userAuthenticated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
