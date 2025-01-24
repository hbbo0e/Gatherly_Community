package gatherly.community.user.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 애플리케이션에서 사용하는 도메인 모델
 */

@Getter
@Builder
public class User {

  // TODO 0124 1100 signup 을 개발하기 위한 User 도메인 만들기 - 여기는 도메인 ⚠️
  /**
   * ❓ 왜 UserEntity 에서 사용하는 userId 는 안 사용할까? -> 이거는 사용하는 로직에 따라 다를 것 같긴 함
   * --> userId 는 데이터베이스의 PK, 엔티티를 식별하는데 사용함
   * 그런데 User 에서는 데이터베이스와 직접적인 연관이 없는 그냥 객체임. DDD 에서는 비즈니스 로직과 직접적인 연관이 없는 기술적인 속성으로 간주됨
   * 만약 포함시킨다면 불필요한 설계 복잡도를 증가시킬 수도 있음
   * --> userId 를 식별로 사용할 수 있잖아?
   * username 이나 email 로 충분함
   */

  private final String username;
  private final String email;
  private final String password;
  private final String profileImage;
  private final Integer followerCount;
  private final Integer followingCount;

  // ⚠️ 기능 개발이 우선, password 필드도 Builder
  // ❓ private final 이 붙은 건 AllArgsConstructor 이 없어도 Builder 가능, 그냥 private 는 AllArgsConstructor 가 있어야 함 왜?
}
