package sam.association.oneToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.association.oneToOne.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
