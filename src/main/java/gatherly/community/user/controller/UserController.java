package gatherly.community.user.controller;

import gatherly.community.user.application.UserService;
import gatherly.community.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  // ⚠️ ResponseEntity 가 아닌 dto 를 controller 마다 짜서 배치 시켜야 함
  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody User user) {
    userService.registerUser(user);
    return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
  }
}