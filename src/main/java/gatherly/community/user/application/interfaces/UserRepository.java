package gatherly.community.user.application.interfaces;

import gatherly.community.user.domain.User;
import java.util.Optional;

public interface UserRepository {
//  User registerUser(User user);
//  Optional<User> findByEmail(String email); // blog 에서 날라온 것
//  boolean existsByUsername(String username);
//  boolean existsByEmail(String email);

  // check
  Optional<User> findByUsername(String username);
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
  void save(User user);
}
