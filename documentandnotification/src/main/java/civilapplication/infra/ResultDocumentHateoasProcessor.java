package civilapplication.infra;

import civilapplication.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ResultDocumentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ResultDocument>> {

    @Override
    public EntityModel<ResultDocument> process(
        EntityModel<ResultDocument> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/issueresultdocument"
                )
                .withRel("issueresultdocument")
        );

        return model;
    }
}
