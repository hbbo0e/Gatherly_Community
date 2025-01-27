package gatherly.community.user.controller;

import gatherly.community.user.application.UserService;
import gatherly.community.user.application.dto.RegisterUserRequest;
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

  @PostMapping("/auth/signup")
  public ResponseEntity<String> signup(@RequestBody RegisterUserRequest request) {
    userService.registerUser(request);
    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
  }
}