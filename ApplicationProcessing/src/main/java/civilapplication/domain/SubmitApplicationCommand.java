package civilapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitApplicationCommand {

    private String applicantId;
    private String minwonType;
    private String applicationReason;
    private List<FileAttachment> attachFiles;
}
