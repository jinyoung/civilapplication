package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ApplicationSubmissionFailed extends AbstractEvent {

    private String applicantId;
    private String errorMessage;
    private String errorDetails;
    private Date attemptedAt;

    public ApplicationSubmissionFailed(Application aggregate) {
        super(aggregate);
    }

    public ApplicationSubmissionFailed() {
        super();
    }
}
//>>> DDD / Domain Event
