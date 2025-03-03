package gatherly.community.user.application;

import gatherly.community.user.application.dto.RegisterUserRequest;
import gatherly.community.user.application.interfaces.UserRepository;
import gatherly.community.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  //private final UserRepository userRepository;

  // 이건 일단 짬뽕
//  public void registerUser(RegisterUserRequest request) {
//    if (userRepository.existsByUsername(request.getUsername())) {
//      throw new IllegalArgumentException("같은 이름이 이미 있어요!");
//    }
//    if (userRepository.existsByEmail(request.getEmail())) {
//      throw new IllegalArgumentException("해당 이메일은 이미 가입되어 있어요!");
//    }
//
//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    String encodedPassword = encoder.encode(request.getPassword());
//    User userWithEncodedPassword = User.builder()
//        .username(request.getUsername())
//        .email(request.getEmail())
//        .password(encodedPassword)
//        .profileImage(request.getProfileImage())
//        .followerCount(0)
//        .followingCount(0)
//        .build();
//
//    userRepository.registerUser(userWithEncodedPassword);
//  }

  // check
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public void registerUser(User user) {
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new IllegalArgumentException("이미 사용 중인 사용자 이름입니다.");
    }
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
    }

    String encodedPassword = passwordEncoder.encode(user.getPassword());
    User securedUser = User.builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .password(encodedPassword)
        .profileImage(user.getProfileImage())
        .followerCount(user.getFollowerCount() != null ? user.getFollowerCount() : 0)
        .followingCount(user.getFollowingCount() != null ? user.getFollowingCount() : 0)
        .build();

    userRepository.save(securedUser);
  }
}