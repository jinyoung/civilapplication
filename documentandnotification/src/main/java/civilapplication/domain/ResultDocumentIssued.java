package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ResultDocumentIssued extends AbstractEvent {

    private Long documentId;
    private String applicationNumber;
    private DocumentStatus status;
    private Date issuedAt;

    public ResultDocumentIssued(ResultDocument aggregate) {
        super(aggregate);
    }

    public ResultDocumentIssued() {
        super();
    }
}
//>>> DDD / Domain Event
