package civilapplication.domain;

import civilapplication.domain.*;
import civilapplication.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ApplicationSubmitted extends AbstractEvent {

    private String applicantId;
    private String minwonType;
    private String applicationReason;
    private Object attachFiles;
    private String issuedNumber;
    private Date submittedAt;
}
