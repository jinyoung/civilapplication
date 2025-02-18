package civilapplication.domain;

import civilapplication.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "notifications",
    path = "notifications"
)
public interface NotificationRepository
    extends PagingAndSortingRepository<Notification, Long> {
    @Query(
        value = "select notification " +
        "from Notification notification " +
        "where(:applicationNumber is null or notification.applicationNumber like %:applicationNumber%) and (:status is null or notification.status = :status) and (:sentDate is null or notification.sentDate = :sentDate)"
    )
    Notification notificationSummary(
        String applicationNumber,
        NotificationStatus status,
        Date sentDate
    );
}
