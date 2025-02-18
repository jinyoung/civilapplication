package civilapplication.domain;

import civilapplication.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "applications",
    path = "applications"
)
public interface ApplicationRepository
    extends PagingAndSortingRepository<Application, String> {
    @Query(
        value = "select application " +
        "from Application application " +
        "where(:applicantId is null or application.applicantId like %:applicantId%) and (:minwonType is null or application.minwonType like %:minwonType%) and (:issuedNumber is null or application.issuedNumber like %:issuedNumber%)"
    )
    List<Application> applicationSummary(
        String applicantId,
        String minwonType,
        String issuedNumber,
        Pageable pageable
    );
}
