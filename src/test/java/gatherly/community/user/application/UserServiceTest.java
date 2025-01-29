//package gatherly.community.user.application;
//
//import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import gatherly.community.user.application.interfaces.UserRepository;
//import gatherly.community.user.domain.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.times;
//
//@ActiveProfiles("test")
//class UserServiceTest {
//
//   private final UserRepository userRepository = mock(UserRepository.class);
//   private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
//   private final UserService userService = new UserService(userRepository, passwordEncoder);
//
//   // 단위 테스트: 정상 회원가입
//   @Test
//   void registerUser_success() {
//      // Given
//      User user = User.builder()
//          .username("testUser")
//          .email("test@example.com")
//          .password("ValidPassword1!")
//          .profileImage(null)
//          .followerCount(0)
//          .followingCount(0)
//          .build();
//
//      when(userRepository.existsByUsername("testUser")).thenReturn(false);
//      when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
//      when(passwordEncoder.encode("ValidPassword1!")).thenReturn("encodedPassword");
//
//      // When
//      userService.registerUser(user);
//
//      // Then
//      // 💭 registerUser (User user) 이고 verify 를 통해서는 boolean 이라 형변환을 해주어야 함
//      verify(userRepository, times(1)).registerUser(any(User.class));
//   }
//
//   // 단위 테스트: 중복 이메일로 회원가입 시도
//   @Test
//   void registerUser_duplicateEmail() {
//      // Given
//      User user = User.builder()
//          .username("testUser")
//          .email("test@example.com")
//          .password("ValidPassword1!")
//          .profileImage(null)
//          .followerCount(0)
//          .followingCount(0)
//          .build();
//
//      when(userRepository.existsByEmail("test@example.com")).thenReturn(true);
//
//      // When & Then
//      assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
//   }
//
//   // 단위 테스트: 이메일 형식 오류
//   @Test
//   void registerUser_invalidEmailFormat() {
//      // Given
//      User user = User.builder()
//          .username("testUser")
//          .email("invalid-email")
//          .password("ValidPassword1!")
//          .profileImage(null)
//          .followerCount(0)
//          .followingCount(0)
//          .build();
//
//      // When & Then
//      assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
//   }
//
//   // 단위 테스트: 비밀번호 정책 위반
//   @Test
//   void registerUser_passwordPolicyViolation() {
//      // Given
//      User user = User.builder()
//          .username("testUser")
//          .email("test@example.com")
//          .password("short")
//          .profileImage(null)
//          .followerCount(0)
//          .followingCount(0)
//          .build();
//
//      // When & Then
//      assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
//   }
//
//}