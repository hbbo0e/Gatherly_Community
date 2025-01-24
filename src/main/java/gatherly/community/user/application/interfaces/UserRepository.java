package gatherly.community.user.application.interfaces;

import gatherly.community.user.domain.User;
import java.util.Optional;

/**
 * 💭 도메인 계층에서 사용하는 데이터 접근 인터페이스 -> User
 * => 도메인 모델인 User 와 데이터베이스 매핑을 담당하는 UserEntity 간의 변환 역할을 담당함
 * -> 그러면 애플리케이션 (서비스) 로직에서는 도메인 모델만 다루도록 해야겠지?
 *
 * JPA 에 국한되지 않고 다른 데이터 저장소 구현체로 교체할 수 있음 -> 추상화를 통한 유연성
 * 이러한 도메인 모델 중심으로 비즈니스 로직을 테스트할 때 JPA 와 같은 구체적인 구현 기술에 의존하지 않음
 */
public interface UserRepository {
  User registerUser(User user);
  Optional<User> findByEmail(String email); // blog 에서 날라온 것
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
}
