package gatherly.community.user.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터베이스와 상호작용을 위한 엔티티
 */
@Entity
@Getter
@Table(name = "community_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

  // TODO 0124 1100 signup 을 개발하기 위한 User domain entity 만들기 - 여기가 데이터베이스와 연결
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password; // ⚠️ security 기반 password, oauth 기반 password 구분?

  @Column(nullable = true)
  private String profileImage;

  @Column(nullable = false)
  private Integer followerCount; // community_feed

  @Column(nullable = false)
  private Integer followingCount; // community_feed

  /**
   * 💭 userentity 에 관해서
   * **blog** ->
   * @Column(name = "", nullable = false, unique = true) 설정
   * 기본 생성자, update(), getter, 그 외 다른 메서드 다수
   * **board** ->
   * @Column 만 설정되어 있음
   * getter, setter, hascode, iseqquals 등등 다수 메서드
   * **community_feed** ->
   * 다른 필드에 어노테이션 설정 되어 있지 않음
   * 기본 생성자인데 user domain 에서 가지고 온, toUser 이라고 하는 빌더로 구성됨
   *
   * gpt ->
   * 칼럼은 @Column(nullable = false, unique = true)
   * 그 외 메서드는 어노테이션으로, getter setter 등등
   * writn ->
   * 칼럼은 @Column(nullable = false, unique = true)
   * 그 외 메서드는 알아서 추가하라는 듯함
   */

  // ⚠️ 아무리 생각해도 비밀번호는 Builder 로 쓰면 안 될 것 같은데 일단 기능 개발이 우선
//  @Builder
//  public UserEntity(String username, String email, String profileImage, Integer followerCount, Integer followingCount) {
//    this.username = username;
//    this.email = email;
//    this.profileImage = profileImage;
//    this.followerCount = followerCount;
//    this.followingCount = followingCount;
//  }
}
