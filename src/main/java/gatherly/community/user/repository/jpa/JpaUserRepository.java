package gatherly.community.user.repository.jpa;

import gatherly.community.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 💭 JPA 기반 데이터 액세스 기능 제공, CRUD 메서드 활용 -> UserEntity 를 다룸
 */

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
}
