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
    collectionResourceRel = "resultDocuments",
    path = "resultDocuments"
)
public interface ResultDocumentRepository
    extends PagingAndSortingRepository<ResultDocument, Long> {
    @Query(
        value = "select resultDocument " +
        "from ResultDocument resultDocument " +
        "where(:documentId is null or resultDocument.documentId = :documentId) and (:applicationNumber is null or resultDocument.applicationNumber like %:applicationNumber%) and (:status is null or resultDocument.status = :status) and (:issuedAt is null or resultDocument.issuedAt = :issuedAt)"
    )
    ResultDocument resultDocumentSummary(
        Long documentId,
        String applicationNumber,
        DocumentStatus status,
        Date issuedAt
    );
}
