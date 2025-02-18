package civilapplication.infra;

import civilapplication.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Application>> {

    @Override
    public EntityModel<Application> process(EntityModel<Application> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/submitapplication"
                )
                .withRel("submitapplication")
        );

        return model;
    }
}
