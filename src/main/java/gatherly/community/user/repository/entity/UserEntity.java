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

  @Column(nullable = true)
  private Integer followerCount; // community_feed

  @Column(nullable = true)
  private Integer followingCount; // community_feed


  // ⚠️ password Builder 미포함, 기능 개발 우선
//  @Builder
//  public UserEntity(String username, String email, String profileImage, Integer followerCount, Integer followingCount) {
//    this.username = username;
//    this.email = email;
//    this.profileImage = profileImage;
//    this.followerCount = followerCount;
//    this.followingCount = followingCount;
//  }
}
