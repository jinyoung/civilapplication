package civilapplication.domain;

import java.util.Date;
import lombok.Data;

@Data
public class NotificationSummaryQuery {

    private String applicationNumber;
    private NotificationStatus status;
    private Date sentDate;
}
