package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UserAuthenticated extends AbstractEvent {

    private Date authenticatedAt;

    public UserAuthenticated(User aggregate) {
        super(aggregate);
    }

    public UserAuthenticated() {
        super();
    }
}
//>>> DDD / Domain Event
