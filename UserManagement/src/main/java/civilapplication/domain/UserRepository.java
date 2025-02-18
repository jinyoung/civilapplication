package civilapplication.domain;

import civilapplication.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository
    extends PagingAndSortingRepository<User, String> {
    @Query(
        value = "select user " +
        "from User user " +
        "where(:username is null or user.username like %:username%)"
    )
    User userLoginStatus(String username);
}
