package civilapplication.domain;

import civilapplication.DocumentandnotificationApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;

    private String applicationNumber;

    private Date sentDate;

    @Embedded
    private ApplicationId applicationId;

    private String recipient;

    private String notificationMethod;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = DocumentandnotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }

    //<<< Clean Arch / Port Method
    public void sendNotification(
        SendNotificationCommand sendNotificationCommand
    ) {
        //implement business logic here:

        NotificationSent notificationSent = new NotificationSent(this);
        notificationSent.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
