package gatherly.community.user.repository.jpa;

import gatherly.community.user.repository.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

//  boolean existsByUsername(String username);
//  boolean existsByEmail(String email);

  // check

  Optional<UserEntity> findByUsername(String username);
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
}
