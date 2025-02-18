package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ApplicationSubmissionFailed extends AbstractEvent {

    private String applicantId;
    private String errorMessage;
    private String errorDetails;
    private Date attemptedAt;
}
