package gatherly.community.user.controller;

import gatherly.community.user.application.UserService;
import gatherly.community.user.application.dto.RegisterRequest;
import gatherly.community.user.application.dto.RegisterUserRequest;
import gatherly.community.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

  private final UserService userService;

//  @PostMapping("/auth/signup")
//  public ResponseEntity<String> signup(@RequestBody RegisterUserRequest request) {
//    userService.registerUser(request);
//    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
//  }

// check

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
    try {
      User user = User.builder()
          .username(request.getUsername())
          .email(request.getEmail())
          .password(request.getPassword())
          .profileImage(request.getProfileImage())
          .build();

      userService.registerUser(user);
      return ResponseEntity.ok("회원가입이 완료되었습니다.");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}