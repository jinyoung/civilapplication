package civilapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SendNotificationCommand {

    private ApplicationId applicationId;
    private String applicationNumber;
    private String recipient;
    private String notificationMethod;
}
