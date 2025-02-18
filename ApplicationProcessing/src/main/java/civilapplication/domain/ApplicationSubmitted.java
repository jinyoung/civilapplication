package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ApplicationSubmitted extends AbstractEvent {

    private String applicantId;
    private String minwonType;
    private String applicationReason;
    private List<FileAttachment> attachFiles;
    private String issuedNumber;
    private Date submittedAt;

    public ApplicationSubmitted(Application aggregate) {
        super(aggregate);
    }

    public ApplicationSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
