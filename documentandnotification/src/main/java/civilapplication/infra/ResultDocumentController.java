package civilapplication.infra;
import civilapplication.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/resultDocuments")
@Transactional
public class ResultDocumentController {
    @Autowired
    ResultDocumentRepository resultDocumentRepository;

    @RequestMapping(value = "/resultDocuments/issueresultdocument",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ResultDocument issueResultDocument(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /resultDocument/issueResultDocument  called #####");
            ResultDocument resultDocument = new ResultDocument();
            resultDocument.issueResultDocument();
            resultDocumentRepository.save(resultDocument);
            return resultDocument;
    }
}
//>>> Clean Arch / Inbound Adaptor
