package civilapplication.infra;

import civilapplication.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/applications")
@Transactional
public class ApplicationController {

    @Autowired
    ApplicationRepository applicationRepository;

    @RequestMapping(
        value = "/applications/submitapplication",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Application submitApplication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SubmitApplicationCommand submitApplicationCommand
    ) throws Exception {
        System.out.println(
            "##### /application/submitApplication  called #####"
        );
        Application application = new Application();
        application.submitApplication(submitApplicationCommand);
        applicationRepository.save(application);
        return application;
    }
}
//>>> Clean Arch / Inbound Adaptor
