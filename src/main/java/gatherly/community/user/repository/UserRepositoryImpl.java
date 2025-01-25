package gatherly.community.user.repository;

import gatherly.community.user.application.interfaces.UserRepository;
import gatherly.community.user.domain.User;
import gatherly.community.user.repository.entity.UserEntity;
import gatherly.community.user.repository.jpa.JpaUserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final JpaUserRepository jpaUserRepository;


  @Override
  public User registerUser(User user) {
    UserEntity entity = UserEntity.builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .profileImage(user.getProfileImage())
        .followerCount(user.getFollowerCount())
        .followingCount(user.getFollowingCount())
        .build();

    entity = jpaUserRepository.save(entity);

    return User.builder()
        .username(entity.getUsername())
        .email(entity.getEmail())
        .profileImage(entity.getProfileImage())
        .followerCount(entity.getFollowerCount())
        .followingCount(entity.getFollowingCount())
        .build();
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return Optional.empty();
  }

  @Override
  public boolean existsByUsername(String username) {
    return jpaUserRepository.existsByUsername(username);
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpaUserRepository.existsByEmail(email);
  }
}
