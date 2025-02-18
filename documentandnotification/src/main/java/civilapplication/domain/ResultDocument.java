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
@Table(name = "ResultDocument_table")
@Data
//<<< DDD / Aggregate Root
public class ResultDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    private String applicationNumber;

    private String recipient;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static ResultDocumentRepository repository() {
        ResultDocumentRepository resultDocumentRepository = DocumentandnotificationApplication.applicationContext.getBean(
            ResultDocumentRepository.class
        );
        return resultDocumentRepository;
    }

    //<<< Clean Arch / Port Method
    public void issueResultDocument() {
        //implement business logic here:

        ResultDocumentIssued resultDocumentIssued = new ResultDocumentIssued(
            this
        );
        resultDocumentIssued.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
