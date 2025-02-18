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
// @RequestMapping(value="/notifications")
@Transactional
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @RequestMapping(
        value = "/notifications/sendnotification",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Notification sendNotification(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SendNotificationCommand sendNotificationCommand
    ) throws Exception {
        System.out.println(
            "##### /notification/sendNotification  called #####"
        );
        Notification notification = new Notification();
        notification.sendNotification(sendNotificationCommand);
        notificationRepository.save(notification);
        return notification;
    }
}
//>>> Clean Arch / Inbound Adaptor
