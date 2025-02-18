package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class NotificationSent extends AbstractEvent {

    private ApplicationId applicationId;
    private String applicationNumber;
    private String recipient;
    private Date sentDate;
    private NotificationStatus status;

    public NotificationSent(Notification aggregate) {
        super(aggregate);
    }

    public NotificationSent() {
        super();
    }
}
//>>> DDD / Domain Event
