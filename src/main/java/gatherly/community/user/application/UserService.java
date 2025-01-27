package gatherly.community.user.application;

import gatherly.community.user.application.dto.RegisterUserRequest;
import gatherly.community.user.application.interfaces.UserRepository;
import gatherly.community.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public void registerUser(RegisterUserRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new IllegalArgumentException("같은 이름이 이미 있어요!");
    }
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("해당 이메일은 이미 가입되어 있어요!");
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    String encodedPassword = encoder.encode(request.getPassword());
    User userWithEncodedPassword = User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(encodedPassword)
        .profileImage(request.getProfileImage())
        .followerCount(0)
        .followingCount(0)
        .build();

    userRepository.registerUser(userWithEncodedPassword);

  }
}