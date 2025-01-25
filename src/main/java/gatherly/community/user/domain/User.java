package gatherly.community.user.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 애플리케이션에서 사용하는 도메인 모델
 */

@Getter
@Builder
public class User {

  // TODO 0124 1100 signup 을 개발하기 위한 User 도메인 만들기 - 여기는 도메인

  private final String username;
  private final String email;
  private final String password;
  private final String profileImage;
  private final Integer followerCount;
  private final Integer followingCount;

  // ⚠️ 기능 개발이 우선, password 필드도 Builder
}
