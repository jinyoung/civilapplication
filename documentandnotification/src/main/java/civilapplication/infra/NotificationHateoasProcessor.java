package civilapplication.infra;

import civilapplication.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class NotificationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Notification>> {

    @Override
    public EntityModel<Notification> process(EntityModel<Notification> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/sendnotification"
                )
                .withRel("sendnotification")
        );

        return model;
    }
}
