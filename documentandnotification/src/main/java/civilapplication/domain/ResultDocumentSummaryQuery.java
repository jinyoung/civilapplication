package civilapplication.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ResultDocumentSummaryQuery {

    private Long documentId;
    private String applicationNumber;
    private DocumentStatus status;
    private Date issuedAt;
}
