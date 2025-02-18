package civilapplication.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ApplicationSummaryQuery {

    private String applicantId;
    private String minwonType;
    private String issuedNumber;
}
