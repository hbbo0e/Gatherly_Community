package gatherly.community.user.application;

import gatherly.community.user.application.interfaces.UserRepository;
import gatherly.community.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public void registerUser(User user) {
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new IllegalArgumentException("같은 이름이 이미 있어요!");
    }
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("해당 이메일은 이미 가입되어 있어요!");
    }

    // ❓이거 그냥 이렇게 하면 그냥 인코딩 된 거 뿐... 아닌가?
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    User userWithEncodedPassword = User.builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .password(encodedPassword)
        .profileImage(user.getProfileImage())
        .followerCount(0)
        .followingCount(0)
        .build();

    userRepository.registerUser(userWithEncodedPassword);
  }
}