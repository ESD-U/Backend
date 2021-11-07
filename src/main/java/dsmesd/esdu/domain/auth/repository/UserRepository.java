package dsmesd.esdu.domain.auth.repository;

import dsmesd.esdu.domain.auth.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
