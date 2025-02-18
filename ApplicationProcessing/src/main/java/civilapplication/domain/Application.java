package civilapplication.domain;

import civilapplication.ApplicationProcessingApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Application_table")
@Data
//<<< DDD / Aggregate Root
public class Application {

    @Id
    private String applicationId;

    private String applicantId;

    private String minwonType;

    private String applicationReason;

    private String issuedNumber;

    @Embedded
    private UserId userId;

    @Embedded
    private File file;

    public static ApplicationRepository repository() {
        ApplicationRepository applicationRepository = ApplicationProcessingApplication.applicationContext.getBean(
            ApplicationRepository.class
        );
        return applicationRepository;
    }

    //<<< Clean Arch / Port Method
    public void submitApplication(
        SubmitApplicationCommand submitApplicationCommand
    ) {
        //implement business logic here:

        ApplicationSubmitted applicationSubmitted = new ApplicationSubmitted(
            this
        );
        applicationSubmitted.publishAfterCommit();
        ApplicationSubmissionFailed applicationSubmissionFailed = new ApplicationSubmissionFailed(
            this
        );
        applicationSubmissionFailed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
