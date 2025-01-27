package gatherly.community.user.domain;

import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 애플리케이션에서 사용하는 도메인 모델
 * security 에서 사용하기 위해 UserDetails 를 implements --> 0125
 */

@Getter
@Builder
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

  // TODO 0124 1100 signup 을 개발하기 위한 User 도메인 만들기 - 여기는 도메인

  private final String username;
  private final String email;
  private final String password;
  private final String profileImage;
  private final Integer followerCount;
  private final Integer followingCount;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("user"));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  // ⚠️ 기능 개발이 우선, password 필드도 Builder


}
